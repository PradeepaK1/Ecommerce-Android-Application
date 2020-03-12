package com.example.ptljdf;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class Main20Activity extends AppCompatActivity {

    String Storage_Path = "All_Equipment _Uploads/";

    String Database_Path = "All_Equipment_Uploads_Database";

    Button ChooseButton, UploadButton;

    EditText name_or_ownername_or_suppliername,phno, mail,address, area,crop_or_produces_or_equipment, stage_or_shopname_or_supplierunit, location ;

    ImageView SelectImage;

    Uri FilePathUri;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    int Image_Request_Code = 7;

    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);

        storageReference = FirebaseStorage.getInstance().getReference();

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        ChooseButton = (Button)findViewById(R.id.ButtonChooseImage);
        UploadButton = (Button)findViewById(R.id.ButtonUploadImage);

        name_or_ownername_or_suppliername = (EditText)findViewById(R.id.ownernameEditText);
        phno = (EditText)findViewById(R.id.phnoEditText);
        mail = (EditText)findViewById(R.id.mailEditText);
        address = (EditText)findViewById(R.id.shopaddressEditText);

        area = (EditText)findViewById(R.id.areaEditText);
        crop_or_produces_or_equipment = (EditText)findViewById(R.id.producesEditText);
        stage_or_shopname_or_supplierunit = (EditText)findViewById(R.id.shopnameEditText);
        location = (EditText)findViewById(R.id.locationEditText);


        SelectImage = (ImageView)findViewById(R.id.ShowImageView);

       progressDialog = new ProgressDialog(Main20Activity.this);

        ChooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Please Select Image"), Image_Request_Code);

            }
        });


        UploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UploadImageFileToFirebaseStorage();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri = data.getData();

            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);

               SelectImage.setImageBitmap(bitmap);

                ChooseButton.setText("Image Selected");

            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getContentResolver();

        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();


        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }

    public void UploadImageFileToFirebaseStorage() {

        if (FilePathUri != null) {

            progressDialog.setTitle("adding Equipment...");

            progressDialog.show();

            StorageReference storageReference2nd = storageReference.child(Storage_Path + System.currentTimeMillis() + "." + GetFileExtension(FilePathUri));

            storageReference2nd.putFile(FilePathUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            String Tempownername = name_or_ownername_or_suppliername.getText().toString().trim();
                            String Tempphno = phno.getText().toString().trim();
                            String Tempmail = mail.getText().toString().trim();
                            String Tempshopaddress = address.getText().toString().trim();

                            String Temparea = area.getText().toString().trim();
                            String Tempproduces = crop_or_produces_or_equipment.getText().toString().trim();
                            String Tempshopname = stage_or_shopname_or_supplierunit.getText().toString().trim();
                            String Templocation = location.getText().toString().trim();


                            progressDialog.dismiss();

                            Toast.makeText(getApplicationContext(), "Equipment added successfully ", Toast.LENGTH_LONG).show();

                            @SuppressWarnings("VisibleForTests")
                            ImageUploadInfo imageUploadInfo= new ImageUploadInfo(Tempownername,Tempphno,Tempmail,Tempshopaddress,Temparea,Tempproduces,Tempshopname,Templocation, taskSnapshot.getStorage().getDownloadUrl().toString());

                            String ImageUploadId = databaseReference.push().getKey();

                            databaseReference.child(ImageUploadId).setValue(imageUploadInfo);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {

                            progressDialog.dismiss();

                            Toast.makeText(Main20Activity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })

                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                            progressDialog.setTitle("adding Equipment...");

                        }
                    });
        }
        else {

            Toast.makeText(Main20Activity.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

        }
    }


}