package com.mja.intercontenentalhotel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mja.intercontenentalhotel.CustomerDetail;
import com.mja.intercontenentalhotel.R;

import java.util.ArrayList;

/**
 * Created by MohammedJuned on 2016-10-22.
 */

public class resItalian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_italian);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.italian, menu);//Menu Resource, Menu
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.novita:
                Toast.makeText(this, "You selected :" + item.getTitle().toString(), Toast.LENGTH_LONG).show();
                final CharSequence[] items = {" Antipasto Platter "," Butterfly Shrimps "," Bruschetta "," Steamed Mussels "," Novita Club"," Graziana "};
                // arraylist to keep the selected items
                final ArrayList selectedItems=new ArrayList();

                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Select the dishes")
                        .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    selectedItems.add(items[indexSelected]);
                                } else if (selectedItems.contains(indexSelected)) {
                                    // Else, if the item is already in the array, remove it
                                    selectedItems.remove(Integer.valueOf(indexSelected));
                                }
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on OK
                                //  You can write the code  to save the selected item here

                                Intent intent = new Intent(((Dialog) dialog).getContext(), CustomerDetail.class);
                                intent.putExtra("menu_items", selectedItems);
                                startActivity(intent);
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on Cancel
                            }
                        }).show();
                break;
            case R.id.santos:
                Toast.makeText(this, "You selected :" + item.getTitle().toString(), Toast.LENGTH_LONG).show();
                final CharSequence[] items2 = {" Minestrone "," Minestra Di Pomodoro "," Insalata Della Casa "," Fagioli Soup ", " Ravioli Verdi "};
                // arraylist to keep the selected items
                final ArrayList selectedItems2=new ArrayList();

                AlertDialog dialog2 = new AlertDialog.Builder(this)
                        .setTitle("Select the dishes")
                        .setMultiChoiceItems(items2, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    selectedItems2.add(items2[indexSelected]);
                                } else if (selectedItems2.contains(indexSelected)) {
                                    // Else, if the item is already in the array, remove it
                                    selectedItems2.remove(Integer.valueOf(indexSelected));
                                }
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on OK
                                //  You can write the code  to save the selected item here

                                Intent intent = new Intent(((Dialog) dialog).getContext(), CustomerDetail.class);
                                intent.putExtra("menu_items", selectedItems2);
                                startActivity(intent);
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on Cancel
                            }
                        }).show();
                break;
            case R.id.romano:
                Toast.makeText(this, "You selected :" + item.getTitle().toString(), Toast.LENGTH_LONG).show();
                final CharSequence[] items3 = {" Calamari Fritti "," Mini Arancini "," Polenta Fries "," Sonoma " , " Tuscan "," Gnocchi "};
                // arraylist to keep the selected items
                final ArrayList selectedItems3=new ArrayList();

                AlertDialog dialog3 = new AlertDialog.Builder(this)
                        .setTitle("Select the dishes")
                        .setMultiChoiceItems(items3, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    selectedItems3.add(items3[indexSelected]);
                                } else if (selectedItems3.contains(indexSelected)) {
                                    // Else, if the item is already in the array, remove it
                                    selectedItems3.remove(Integer.valueOf(indexSelected));
                                }
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on OK
                                //  You can write the code  to save the selected item here
                                Intent intent = new Intent(((Dialog) dialog).getContext(), CustomerDetail.class);
                                intent.putExtra("menu_items", selectedItems3);
                                startActivity(intent);
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on Cancel
                            }
                        }).show();
                break;
            case R.id.la:
                Toast.makeText(this, "You selected :" + item.getTitle().toString(), Toast.LENGTH_LONG).show();
                final CharSequence[] items4 = {" Spinach Salad "," House Salad "," Mushroom Risotto "," Focaccia Bread ", " Pasta Carbonara "," Zuppa Del Giorno "};
                // arraylist to keep the selected items
                final ArrayList selectedItem4=new ArrayList();

                AlertDialog dialog4 = new AlertDialog.Builder(this)
                        .setTitle("Select the dishes")
                        .setMultiChoiceItems(items4, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    selectedItem4.add(items4[indexSelected]);
                                } else if (selectedItem4.contains(indexSelected)) {
                                    // Else, if the item is already in the array, remove it
                                    selectedItem4.remove(Integer.valueOf(indexSelected));
                                }
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on OK
                                //  You can write the code  to save the selected item here
                                Intent intent = new Intent(((Dialog) dialog).getContext(), CustomerDetail.class);
                                intent.putExtra("menu_items", selectedItem4);
                                startActivity(intent);
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on Cancel
                            }
                        }).show();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
