package edu.wpi.cs3733.D22.teamC.entity.service_request;

import edu.wpi.cs3733.D22.teamC.entity.service_request.lab_system.LabSystemSR;

public class LabSystemSRTestFactory extends ServiceRequestTestFactory<LabSystemSR> {
    public LabSystemSR create() {

        LabSystemSR serviceRequest = new LabSystemSR();

        ServiceRequest.RequestType requestType = ServiceRequest.RequestType.Lab_System;
        LabSystemSR.LabType labType = LabSystemSR.LabType.values()[getGenerator().nextInt(5)];
        String patientID = "JohnCena";

        serviceRequest.setRequestType(requestType);
        serviceRequest.setLabType(labType);
        serviceRequest.setPatientID(patientID);

        return super.create(serviceRequest);
        
    }
}
