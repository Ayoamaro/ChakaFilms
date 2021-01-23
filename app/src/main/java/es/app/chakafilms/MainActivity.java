package es.app.chakafilms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String JSON_STRING="{\"Peliculas\":{\"idPelicula\":\"1\",\"titulo\":\"Titanic\",\"agno\":\"1997\",\"pais\":\"EE.UU\",\"director\":\"James Cameron\",\"actores\":\"Leonardo DiCaprio, Kate Winslet\",\"sipnosis\":\"Jack, un joven artista, gana en una partida de cartas un pasaje para viajar a América en el Titanic, el transatlántico más grande y seguro jamás construido. A bordo conoce a Rose, una joven de una buena familia venida a menos que va a contraer un matrimon\"}}";

    String strID, strTITULO, strAGNO, strPAIS, strDIRECTOR, strACTORES, strSIPNOSIS;
    TextView fondoID, fondoTITULO, fondoAGNO, fondoPAIS, fondoDIRECTOR, fondoACTORES, fondoSIPNOSIS;
    ImageView fondoPHOTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fondoPHOTO=(ImageView) findViewById(R.id.fondoPHOTO);
        fondoID=(TextView) findViewById(R.id.fondoID);
        fondoTITULO=(TextView) findViewById(R.id.fondoTITULO);
        fondoAGNO=(TextView) findViewById(R.id.fondoAGNO);
        fondoPAIS=(TextView) findViewById(R.id.fondoPAIS);
        fondoDIRECTOR=(TextView) findViewById(R.id.fondoDIRECTOR);
        fondoACTORES=(TextView) findViewById(R.id.fondoACTORES);
        fondoSIPNOSIS=(TextView) findViewById(R.id.fondoSIPNOSIS);

        try {
            JSONObject obj=new JSONObject(JSON_STRING);
            JSONObject fondo=obj.getJSONObject("Peliculas");

            strID=fondo.getString("idPelicula");
            strTITULO=fondo.getString("titulo");
            strAGNO=fondo.getString("agno");
            strPAIS=fondo.getString("pais");
            strDIRECTOR=fondo.getString("director");
            strACTORES=fondo.getString("actores");
            strSIPNOSIS=fondo.getString("sipnosis");

            fondoPHOTO.setImageResource(R.drawable.titanic);
            fondoID.setText("ID de la película: " + strID);
            fondoTITULO.setText("ISBN: " + strTITULO);
            fondoAGNO.setText("Año: " + strAGNO);
            fondoPAIS.setText("País: " + strPAIS);
            fondoDIRECTOR.setText("Director: " + strDIRECTOR);
            fondoACTORES.setText("Actores: " + strACTORES);
            fondoSIPNOSIS.setText("Sipnosis: " + strSIPNOSIS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}