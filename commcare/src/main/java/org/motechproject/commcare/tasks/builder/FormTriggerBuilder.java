package org.motechproject.commcare.tasks.builder;

import org.motechproject.commcare.config.Config;
import org.motechproject.commcare.domain.CommcareApplicationJson;
import org.motechproject.commcare.domain.CommcareModuleJson;
import org.motechproject.commcare.domain.FormSchemaJson;
import org.motechproject.commcare.domain.FormSchemaQuestionJson;
import org.motechproject.commcare.service.CommcareConfigService;
import org.motechproject.commcare.service.CommcareSchemaService;
import org.motechproject.tasks.contract.EventParameterRequest;
import org.motechproject.tasks.contract.TriggerEventRequest;

import java.util.ArrayList;
import java.util.List;

import static org.motechproject.commcare.events.constants.EventDataKeys.CASE_ID;
import static org.motechproject.commcare.events.constants.EventDataKeys.CONFIG_NAME;
import static org.motechproject.commcare.events.constants.EventDataKeys.META_APP_VERSION;
import static org.motechproject.commcare.events.constants.EventDataKeys.META_DEVICE_ID;
import static org.motechproject.commcare.events.constants.EventDataKeys.META_INSTANCE_ID;
import static org.motechproject.commcare.events.constants.EventDataKeys.META_TIME_END;
import static org.motechproject.commcare.events.constants.EventDataKeys.META_TIME_START;
import static org.motechproject.commcare.events.constants.EventDataKeys.META_USERNAME;
import static org.motechproject.commcare.events.constants.EventDataKeys.META_USER_ID;
import static org.motechproject.commcare.events.constants.EventDataKeys.REGISTERED_CASE_NAME;
import static org.motechproject.commcare.events.constants.EventDataKeys.REGISTERED_CASE_TYPE;
import static org.motechproject.commcare.events.constants.EventSubjects.FORMS_EVENT;

/**
 * The <code>FormTriggerBuilder</code> class builds tasks triggers for each form
 * present in MOTECH database. Each trigger has got its own attributes, depending on the
 * actual fields present in a certain form.
 */
public class FormTriggerBuilder implements TriggerBuilder {

    private CommcareSchemaService schemaService;
    private CommcareConfigService configService;

    private static final String RECEIVED_FORM = "Received Form";

    /**
     * Creates an instance of the {@link FormTriggerBuilder} class that can be used for building form triggers. It will
     * use the given {@code schemaService}, {@code configService} fir building them.
     *
     * @param schemaService the schema service
     * @param configService  the configuration service
     */
    public FormTriggerBuilder(CommcareSchemaService schemaService, CommcareConfigService configService) {
        this.schemaService = schemaService;
        this.configService = configService;
    }

    @Override
    public List<TriggerEventRequest> buildTriggers() {
        List<TriggerEventRequest> triggers = new ArrayList<>();

        for (Config config : configService.getConfigs().getConfigs()) {
            for (CommcareApplicationJson application : schemaService.retrieveApplications(config.getName())) {
                for (CommcareModuleJson module : application.getModules()) {
                    for (FormSchemaJson form : module.getFormSchemas()) {
                        List<EventParameterRequest> parameters = new ArrayList<>();
                        String applicationName = application.getApplicationName();
                        String formName = form.getFormName();
                        addMetadataFields(parameters);
                        addCaseFields(parameters);

                        for (FormSchemaQuestionJson question : form.getQuestions()) {
                            parameters.add(new EventParameterRequest(question.getQuestionValue(), question.getQuestionValue()));
                        }

                        String displayName = DisplayNameHelper.buildDisplayName(RECEIVED_FORM, formName, applicationName, config.getName());

                        triggers.add(new TriggerEventRequest(displayName, FORMS_EVENT + "." + config.getName() + "." + form.getXmlns(),
                                null, parameters, FORMS_EVENT));
                    }
                }
            }
        }
        return triggers;
    }

    private void addCaseFields(List<EventParameterRequest> parameters) {
        parameters.add(new EventParameterRequest("commcare.case.field.caseId", CASE_ID));
        parameters.add(new EventParameterRequest("commcare.case.field.caseType", REGISTERED_CASE_TYPE));
        parameters.add(new EventParameterRequest("commcare.case.field.caseName", REGISTERED_CASE_NAME));
    }

    private void addMetadataFields(List<EventParameterRequest> parameters) {
        parameters.add(new EventParameterRequest("commcare.form.field.instanceId", META_INSTANCE_ID));
        parameters.add(new EventParameterRequest("commcare.form.field.userId", META_USER_ID));
        parameters.add(new EventParameterRequest("commcare.form.field.deviceId", META_DEVICE_ID));
        parameters.add(new EventParameterRequest("commcare.form.field.username", META_USERNAME));
        parameters.add(new EventParameterRequest("commcare.form.field.appVersion", META_APP_VERSION));
        parameters.add(new EventParameterRequest("commcare.form.field.timeStart", META_TIME_START));
        parameters.add(new EventParameterRequest("commcare.form.field.timeEnd", META_TIME_END));
        parameters.add(new EventParameterRequest("commcare.field.configName", CONFIG_NAME));
    }
}
