package com.java.employee.Routes;

import com.google.api.Documentation;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.java.employee.Model.EmployeeModel;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class EmployeeRoute {

    public String createEmployee(EmployeeModel employeeModel) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("user_employee").document(employeeModel.getDocumentId()).set(employeeModel);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public EmployeeModel getEmployee(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("user_employee").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        EmployeeModel employeeModel;
        if(document.exists()) {
            employeeModel = document.toObject(EmployeeModel.class);
            return employeeModel;
        }
        return null;
    }
    public String updateEmployee(EmployeeModel employeeModel) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", employeeModel.getName());
        // Add more fields and their updated values as needed

        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("user_employee")
                .document(employeeModel.getDocumentId())
                .update(updates);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    public String deleteEmployee(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("user_employee").document(documentId).delete();
        return "Successfully deleted" + documentId;
    }


}
