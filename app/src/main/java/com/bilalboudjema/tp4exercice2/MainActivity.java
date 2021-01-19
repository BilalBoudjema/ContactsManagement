package com.bilalboudjema.tp4exercice2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText edtNom;
    EditText edtPrenom;
    EditText edtTelephone;
    Button btnAjouter;
    ListView myListView;

    Adapter ContactNouveau;

    ArrayList<Contact> arrayListContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNom = findViewById(R.id.edtNom);
        edtPrenom = findViewById(R.id.edtPrenom);
        edtTelephone = findViewById(R.id.edtTelephone);
        btnAjouter = findViewById(R.id.btnAjouter);
        myListView = findViewById(R.id.myListView);

        // 3 - a
        arrayListContact = new ArrayList<Contact>();
        // 5  instancier un objet de type AdapterContact
        arrayListContact.add(new Contact("Bilal", "Boudjema", 0550757525));

        ContactNouveau = new Adapter(arrayListContact);
        myListView.setAdapter(ContactNouveau);

        btnAjouter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(edtNom.getText().toString().equals("")||edtPrenom.getText().toString().equals("")|| edtTelephone.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Des information  Manquantes !!! SVP Remplire", Toast.LENGTH_SHORT).show();
                }else
                {
                    ajouter();
                    Toast.makeText(MainActivity.this, "Contacte Ajouter Avec Succès !!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void ajouter() {
        Contact Contact = new Contact(edtNom.getText().toString(), edtPrenom.getText().toString(), Integer.parseInt(edtTelephone.getText().toString()));
        arrayListContact.add(Contact);

        // Question 5-d ( mettre à jour la liste une fois un nouveau cintact est ajouter à la liste )
        ContactNouveau.notifyDataSetChanged();
    }


    class Adapter extends BaseAdapter {

        ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

        public Adapter(ArrayList<Contact> listContact) {
            this.contactArrayList = listContact;
        }

        @Override
        public int getCount() {
            return contactArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return contactArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.contact_item, null);
            TextView txtNom;
            TextView txtPre;
            TextView txtTel;
            ImageButton BtnImgTele;
            txtNom = view.findViewById(R.id.txtNom);
            txtPre = view.findViewById(R.id.txtPre);
            txtTel = view.findViewById(R.id.txtTel);
            BtnImgTele = view.findViewById(R.id.BtnImgTele);
            txtNom.setText(contactArrayList.get(position).Nom);
            txtPre.setText(contactArrayList.get(position).Prenom);
            txtTel.setText(Integer.toString(contactArrayList.get(position).Telephone));
            BtnImgTele.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    MakeCall(Integer.toString(contactArrayList.get(position).getTelephone()));
                }
            });
            return view;
        }

        // La méthode qui fait un appelle
        public void  MakeCall(String telnum)
        {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", telnum, null));
            startActivity(intent);
        }
    }


}


