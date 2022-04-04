package edu.wpi.cs3733.D22.teamC.models.service_request.medical_equipment;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import edu.wpi.cs3733.D22.teamC.entity.service_request.medical_equipment.MedicalEquipmentSR;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;

public class MedicalEquipmentSRTable extends RecursiveTreeObject<MedicalEquipmentSRTable> {

    StringProperty equipmentType;
    StringProperty equipmentID;

    StringProperty assigneeID;
    StringProperty location;
    StringProperty status;
    StringProperty priority;

    public MedicalEquipmentSRTable(String equipmentType, String equipmentID, String assigneeID,
                                   String location, String status, String priority){
        this.equipmentID = new SimpleStringProperty(equipmentID);
        this.equipmentType =  new SimpleStringProperty(equipmentType);
        this.assigneeID = new SimpleStringProperty(assigneeID);
        this.location = new SimpleStringProperty(location);
        this.status = new SimpleStringProperty(status);
        this.priority = new SimpleStringProperty(priority);
    }

    public MedicalEquipmentSRTable(MedicalEquipmentSR medicalEquipmentSR) {
        this.equipmentID = new SimpleStringProperty(medicalEquipmentSR.getEquipmentID());
        this.assigneeID = new SimpleStringProperty(medicalEquipmentSR.getAssigneeID());
        this.location = new SimpleStringProperty(medicalEquipmentSR.getLocation());
        this.status = new SimpleStringProperty(medicalEquipmentSR.getStatus().toString());
        this.priority = new SimpleStringProperty(medicalEquipmentSR.getPriority().toString());
    }

    public String getEquipmentType() {
        return equipmentType.get();
    }

    public StringProperty equipmentTypeProperty() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType.set(equipmentType);
    }

    public String getEquipmentID() {
        return equipmentID.get();
    }

    public StringProperty equipmentIDProperty() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID.set(equipmentID);
    }

    public String getAssigneeID() {
        return assigneeID.get();
    }

    public StringProperty assigneeIDProperty() {
        return assigneeID;
    }

    public void setAssigneeID(String assigneeID) {
        this.assigneeID.set(assigneeID);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getPriority() {
        return priority.get();
    }

    public StringProperty priorityProperty() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    public static void createTableColumns(JFXTreeTableView<MedicalEquipmentSRTable> table) {
        table.setColumnResizePolicy( TreeTableView.CONSTRAINED_RESIZE_POLICY );
        //Columns for table
        JFXTreeTableColumn<MedicalEquipmentSRTable, String> IDCol = new JFXTreeTableColumn<>("Priority");
        IDCol.setMaxWidth(1f * Integer.MAX_VALUE * 16.66);
        IDCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String> param) {
                return param.getValue().getValue().priorityProperty();
            }
        });
        JFXTreeTableColumn<MedicalEquipmentSRTable, String> assigneeCol = new JFXTreeTableColumn<>("Assignee");
        assigneeCol.setMaxWidth(1f * Integer.MAX_VALUE * 16.66);
        assigneeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String> param) {
                return param.getValue().getValue().assigneeIDProperty();
            }
        });
        JFXTreeTableColumn<MedicalEquipmentSRTable, String> statusCol = new JFXTreeTableColumn<>("Status");
        statusCol.setMaxWidth(1f * Integer.MAX_VALUE * 16.66);
        statusCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String> param) {
                return param.getValue().getValue().statusProperty();
            }
        });
        JFXTreeTableColumn<MedicalEquipmentSRTable, String> locationCol = new JFXTreeTableColumn<>("Location");
        locationCol.setMaxWidth(1f * Integer.MAX_VALUE * 16.66);
        locationCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String> param) {
                return param.getValue().getValue().locationProperty();
            }
        });
        JFXTreeTableColumn<MedicalEquipmentSRTable, String> typeCol = new JFXTreeTableColumn<>("Type");
        typeCol.setMaxWidth(1f * Integer.MAX_VALUE * 16.66);
        typeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String> param) {
                return param.getValue().getValue().equipmentTypeProperty();
            }
        });
        JFXTreeTableColumn<MedicalEquipmentSRTable, String> typeIDCol = new JFXTreeTableColumn<>("EquipID");
        typeIDCol.setMaxWidth(1f * Integer.MAX_VALUE * 16.66);
        typeIDCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MedicalEquipmentSRTable, String> param) {
                return param.getValue().getValue().equipmentIDProperty();
            }
        });

        // Sets columns
        table.getColumns().setAll(IDCol, assigneeCol, statusCol, locationCol, typeCol, typeIDCol);
    }
}
