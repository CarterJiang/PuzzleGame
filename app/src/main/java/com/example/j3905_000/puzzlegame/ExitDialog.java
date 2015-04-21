package com.example.j3905_000.puzzlegame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by j3905_000 on 4/3/2015.
 */
public class ExitDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder theDialog=new AlertDialog.Builder(getActivity());
        theDialog.setTitle("Exit ");
        theDialog.setMessage("Do you really want to exit the game?");
       theDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Intent intent = new Intent(getActivity(),MainActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               intent.putExtra("EXIT", true);
               startActivity(intent);





           }
       });
        theDialog.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //return super.onCreateDialog(savedInstanceState);
        return theDialog.show();

    }
}
