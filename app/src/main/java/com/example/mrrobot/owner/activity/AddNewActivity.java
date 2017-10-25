package com.example.mrrobot.owner.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mrrobot.owner.MySingleton;
import com.example.mrrobot.owner.Owner;
import com.example.mrrobot.owner.R;
import com.example.mrrobot.owner.database.DatabaseHelper;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

public class AddNewActivity extends AppCompatActivity {
    private TextView TxtName, TxtEmail;
    private LinearLayout UploadForm, UserForm;
    private EditText name, address, user, email;
    private ImageView Img;
    private Bitmap bitmap;
    private Gson gson;
    private String uploadUrl = "http://192.168.0.10/owner/SaveOwner.php";
    private Owner owner;
    private static final int Img_Request = 777;


    DatabaseHelper myDb;
//    EditText textSalonName, textSalonAddress, textManager, textEmail, textId;
//    Button btnAddData;
//    Button btnviewAll;
//    Button btnUpdate;
//    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);


        TxtName = (TextView) findViewById(R.id.txtName);
        TxtEmail = (TextView) findViewById(R.id.txtEmail);
        name = (EditText) findViewById(R.id.salonName);
        address = (EditText) findViewById(R.id.salonAddress);
        user = (EditText) findViewById(R.id.managerOwner);
        email = (EditText) findViewById(R.id.emailOwner);
        UploadForm = (LinearLayout) findViewById(R.id.uploadFrom);
        UserForm = (LinearLayout) findViewById(R.id.userForm);
        Img = (ImageView) findViewById(R.id.img);
        myDb = new DatabaseHelper(this);

//        textSalonName = (EditText) findViewById(R.id.salonName);
//        textSalonAddress = (EditText) findViewById(R.id.salonAddress);
//        textManager = (EditText) findViewById(R.id.managerOwner);
//        textEmail = (EditText) findViewById(R.id.emailOwner);
//        textId = (EditText) findViewById(R.id.idOwner);
//        btnAddData = (Button) findViewById(R.id.bConfirm);
//        btnviewAll = (Button) findViewById(R.id.bShow);
//        btnUpdate = (Button)findViewById(R.id.bUpdate);
//        btnDelete = (Button)findViewById(R.id.bDelete);

//        AddData();
//        viewAll();
//        UpdateData();
//        DeleteData();
//
//        Button btn1 = (Button)findViewById(R.id.bCancel);
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), InformationActivity.class);
//                startActivity(i);
//            }
//        });
    }

    public void bPicture(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, Img_Request);

    }

    public void uploadSalon(View view) {
        String sName = name.getText().toString();
        String sEmail = email.getText().toString();
        String sAddress = address.getText().toString();
        String mUser = user.getText().toString();
        String image = imageToString();

        owner = new Owner(sName, sAddress, mUser, sEmail, image);
        gson = new Gson();
        final String uploadJson = gson.toJson(owner);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, uploadUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        gson = new Gson();
                        owner = gson.fromJson(response, Owner.class);
                        displayAlert(owner);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("owner", uploadJson);
                return params;
            }
        };
        MySingleton.getInstance(this).addToRequestQue(stringRequest);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Img_Request && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                Img.setImageBitmap(bitmap);
                UserForm.setVisibility(View.GONE);
                UploadForm.setVisibility(View.VISIBLE);
                TxtName.setText(name.getText().toString());
                TxtEmail.setText(email.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imageArray, Base64.DEFAULT);
    }

    private void displayAlert(Owner owner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Server Response lul...");
        builder.setMessage(owner.getResponse());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create();
        builder.show();
    }

    //    public void DeleteData(){
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Integer deletedRows = myDb.deleteData(textId.getText().toString());
//                if(deletedRows > 0)
//                    Toast.makeText(AddNewActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(AddNewActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void UpdateData(){
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isUpdate = myDb.updateData(textId.getText().toString(), textSalonName.getText().toString(), textSalonAddress.getText().toString(),
//                        textManager.getText().toString(), textEmail.getText().toString());
//                if(isUpdate == true)
//                    Toast.makeText(AddNewActivity.this, "Data Update", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(AddNewActivity.this, "Data Not Update", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void AddData() {
//        btnAddData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean isInserted = myDb.insertData(textSalonName.getText().toString(), textSalonAddress.getText().toString(), textManager.getText().toString(), textEmail.getText().toString());
//                if(isInserted = true)
//                    Toast.makeText(AddNewActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(AddNewActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void viewAll(){
//        btnviewAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Cursor res = myDb.getAllData();
//                if(res.getCount() == 0){
//                    // show message
//                    showMessage("Error", "Nothhing Found");
//                    return;
//                }
//
//                StringBuffer buffer = new StringBuffer();
//                while (res.moveToNext()){
//                    buffer.append("Id :" + res.getString(0)+ "\n");
//                    buffer.append("Salon Name :" + res.getString(1)+ "\n");
//                    buffer.append("Salon Address :" + res.getString(2)+ "\n");
//                    buffer.append("Manager Name :" + res.getString(3)+ "\n");
//                    buffer.append("Email :" + res.getString(4)+ "\n\n");
//                }
//
//                //show all data
//                showMessage("Data", buffer.toString());
//            }
//        });
//    }
//
//    public void showMessage(String title, String Message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }

//    public void addNew(View view){
//
//        startActivity(new Intent(this,AddNewActivity.class));
//
//    }
//
//    public void cardView1(View view){
//
//        startActivity(new Intent(this,InformationActivity.class));
//
//    }

}
