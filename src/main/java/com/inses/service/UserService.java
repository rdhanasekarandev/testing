package com.inses.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.inses.modal.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class UserService {

    public List<User> getAllUser()throws ExecutionException, InterruptedException{
        Firestore dbFireStore= FirestoreClient.getFirestore();
        List<User> user=new ArrayList<>();

        ApiFuture<QuerySnapshot> future = dbFireStore.collection("User").get();
        List<QueryDocumentSnapshot> documentSnapshots = future.get().getDocuments();
        for (QueryDocumentSnapshot queryDocumentSnapshot:documentSnapshots){
            user.add(queryDocumentSnapshot.toObject(User.class));
        }
        return user;
    }

}
