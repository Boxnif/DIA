package com.KM.boxnif.dia;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.LinkedList;

/**
 * Created by Boxnif on 23.04.2016.
 */
public class Utility
{
    Intent i;
    public static int gebT,gebM,gebY,heuteT,heuteM,heuteY,age,month;
    LinkedList<String> strlist = new LinkedList<>();
    LinkedList<String> strlist123 = new LinkedList<>();
    LinkedList<String> strlist369 = new LinkedList<>();
    LinkedList<String> strlist246 = new LinkedList<>();
    LinkedList<String> strlist63 = new LinkedList<>();

    public static String vor,nach,alter;
    public static int modul_1_punkte;
    public static double modul_1_assPkt = 0;
    public static String bbc;
    public static int modul_2_punkte;
    public static double modul_2_assPkt = 0;
    public static int modul_3_punkte;
    public static double modul_3_assPkt = 0;
    public static int modul_4_punkte;
    public static double modul_4_assPkt = 0;
    public static int modul_5_punkte;
    public static double modul_5_assPkt = 0;
    public static int modul_6_punkte;
    public static double modul_6_assPkt = 0;

    /**
     *
     * @param spin ist die liste die alle punkte einliesßt
     * ändert die Globale Variable für die Erfassten Assesmentpunkte
     */
    public void mod_1(LinkedList<Spinner> spin)
    {
        strlist = spinnerToString(spin);
        modul_1_punkte = 0;
        for(String str: strlist)
        {
            modul_1_punkte +=reform0123(str);
        }
        modul_1_assPkt = mod_1_assPkt(modul_1_punkte);
    }
    public void mod_2(LinkedList<Spinner> spin)
    {
        strlist = spinnerToString(spin);
        modul_2_punkte = 0;
        for(String str: strlist)
        {
            modul_2_punkte +=reform0123(str);
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void mod_3(LinkedList<Spinner> spin)
    {
        strlist = spinnerToString(spin);
        modul_3_punkte = 0;
        for(String str: strlist)
        {
            modul_3_punkte +=reform0135(str);
        }
        modul_3_assPkt = mod_3_assPkt(modul_3_punkte);
    }
    public void mod_4(LinkedList<Spinner> spin123, LinkedList<Spinner> spin369, LinkedList<Spinner> spin246, LinkedList<Spinner> spin63)
    {
        modul_4_punkte = 0;
        strlist123 = spinnerToString(spin123);
        strlist369 = spinnerToString(spin369);
        strlist246 = spinnerToString(spin246);
        strlist63 = spinnerToString(spin63);

        for(String str: strlist123)
        {
            modul_4_punkte +=reform0123(str);
        }
        for(String str: strlist369)
        {
            modul_4_punkte +=reform0369(str);
        }
        for(String str: strlist246)
        {
            modul_4_punkte +=reform0246(str);
        }
        for(String str: strlist63)
        {
            modul_4_punkte +=reform063(str);
        }


        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void mod_5(LinkedList<EditText>mod1t,LinkedList<EditText>mod1w,LinkedList<EditText>mod1m,LinkedList<EditText>mod2t,LinkedList<EditText>mod2w,LinkedList<EditText>mod2m,EditText mod3t,EditText mod3w,EditText mod3m,LinkedList<EditText> mod4w,LinkedList<EditText> mod4m, EditText ed1, EditText ed2,Spinner spin)
    {
        modul_5_punkte = 0;
        modul_5_punkte = modul_5_punkte+mod_5_1(mod1t,mod1w,mod1m);
        modul_5_punkte = modul_5_punkte+mod_5_2(mod2t,mod2w,mod2m);
        modul_5_punkte = modul_5_punkte+mod_5_3(mod3t,mod3w,mod3m);
        modul_5_punkte = modul_5_punkte+mod_5_4(mod4w,mod4m,ed1,ed2);
        modul_5_punkte = modul_5_punkte+mod_5_5(spin);
        modul_5_assPkt = modul_5_assPkt(modul_5_punkte);
    }
    private int mod_5_1(LinkedList<EditText> tage,LinkedList<EditText> wochen,LinkedList<EditText> monate)
    {
        double day = 0;
        for(EditText e: tage)
        {
            if(!e.getText().toString().equals(""))
            {
                day = day + Integer.parseInt(e.getText().toString());
            }
        }
        for(EditText e: wochen)
        {
            if(!e.getText().toString().equals(""))
            {
                day = day + Integer.parseInt(e.getText().toString())/7;
            }

        }
        for(EditText e: monate)
        {
            if(!e.getText().toString().equals(""))
            {
                day = day + Integer.parseInt(e.getText().toString())/30;
            }

        }
        if(day<1)
            {return 0;}
        else if(day>=1&&day<=3)
            {return 1;}
        else if(day>3&&day<=8)
            {return 2;}
        else{return 3;}
    }
    private int mod_5_2(LinkedList<EditText> tage,LinkedList<EditText> wochen,LinkedList<EditText> monate)
    {
        double day = 0;
        double week;
        for(EditText e: tage)
        {
            if(!e.getText().toString().equals(""))
            {
                day = day + Integer.parseInt(e.getText().toString());
            }
        }
        for(EditText e: wochen)
        {
            if(!e.getText().toString().equals(""))
            {
                day = day + Integer.parseInt(e.getText().toString())/7;
            }

        }
        for(EditText e: monate)
        {
            if(!e.getText().toString().equals(""))
            {
                day = day + Integer.parseInt(e.getText().toString())/30;
            }

        }
        week = day*7;
        if(week<1)
            {return 0;}
        else if(week>=1&&week<=7)
            {return 1;}
        else if(day>=1&&day<=3)
            {return 2;}
        else{return 3;}
    }
    private int mod_5_3(EditText tage,EditText wochen,EditText monate)
    {
        double day = 0;
        if(!tage.getText().toString().equals(""))
        {
            if (Integer.parseInt(tage.getText().toString()) >= 1)
            {
                day = day + 60;
            }
        }
        if(!wochen.getText().toString().equals(""))
        {
            day = day + Integer.parseInt(wochen.getText().toString())*8.6;
        }
        if(!monate.getText().toString().equals(""))
        {
            day = day + Integer.parseInt(monate.getText().toString())*2;
        }



        if(day<4.3)
        {return 0;}
        else if(day>=4.3&&day<8.6)
        {return 1;}
        else if(day>=8.6&&day<12.9)
        {return 2;}
        else if(day>=12.9&&day<60)
        {return 3;}
        else{return 6;}
    }
    private int mod_5_4(LinkedList<EditText> wochen,LinkedList<EditText> monate, EditText ed1, EditText ed2)
    {
        double month = 0;

        for(EditText e: wochen)
        {
            if(!e.getText().toString().equals(""))
            {
                month = month + Integer.parseInt(e.getText().toString())*4.3;
            }

        }
        for(EditText e: monate)
        {
            if(!e.getText().toString().equals(""))
            {
                month = month + Integer.parseInt(e.getText().toString());
            }

        }
        if(!ed1.getText().toString().equals(""))
        {
            month = month + Integer.parseInt(ed1.getText().toString())*8.6;
        }
        if(!ed1.getText().toString().equals(""))
        {
            month = month + Integer.parseInt(ed2.getText().toString())*2;
        }


        if(month<4.3)
            {return 0;}
        else if(month>=4.3&&month<8.6)
            {return 1;}
        else if(month>=8.6&&month<12.9)
            {return 2;}
        else if(month>=12.9&&month<60)
            {return 3;}
        else{return 6;}
    }
    private int mod_5_5(Spinner spin)
    {
        return reform0123(spin.getSelectedItem().toString());
    }
    public void mod_6(LinkedList<Spinner> spin)
    {
        strlist = spinnerToString(spin);
        modul_6_punkte = 0;
        for(String str: strlist)
        {
            modul_6_punkte +=reform0123(str);
        }
        modul_6_assPkt = mod_6_assPkt(modul_6_punkte);
    }

    /*
     * @param der String des Gerade eingelesenen Spinners
     * @return die entsprechenden Punkte
     */
    private int reform0123(String s)
    {
        if (s.equals("überwiegend selbstständig")||s.equals("Fähigkeit größtenteils vorhanden überwiegend selbstständig"))
        {
            return 1;

        }
        else if (s.equals("überwiegend unselbstständig")||s.equals("Fähigkeit in geringem Maße vorhanden"))
        {
            return 2;
        }
        else if (s.equals("unselbstständig")||s.equals("Fähigkeit nicht vorhanden"))
        {
            return 3;
        }
        else
        {
            return 0;
        }

    }
    /*
     * @param der String des Gerade eingelesenen Spinners
     * @return die entsprechenden Punkte
     */
    private int reform0135(String s)
    {
        if (s.equals("selten (ein- bis dreimal innerhalb von zwei Wochen)"))
        {
            return 1;
        }
        else if (s.equals("häufig (zweimal bis mehrmals wöchentlich, aber nicht täglich)"))
        {
            return 3;
        }
        else if (s.equals("täglich"))
        {
            return 5;
        }
        else
        {
            return 0;
        }

    }
    /*
     * @param der String des Gerade eingelesenen Spinners
     * @return die entsprechenden Punkte
     */
    private int reform0246(String s)
    {
        if (s.equals("überwiegend selbstständig"))
        {
            return 2;
        }
        else if (s.equals("überwiegend unselbstständig"))
        {
            return 4;
        }
        else if (s.equals("unselbstständig"))
        {
            return 6;
        }
        else
        {
            return 0;
        }

    }
    /*
     * @param der String des Gerade eingelesenen Spinners
     * @return die entsprechenden Punkte
     */
    private int reform0369(String s)
    {
        if (s.equals("überwiegend selbstständig"))
        {
            return 3;
        }
        else if (s.equals("überwiegend unselbstständig"))
        {
            return 6;
        }
        else if (s.equals("unselbstständig"))
        {
            return 9;
        }
        else
        {
            return 0;
        }

    }
    /*
     * @param der String des Gerade eingelesenen Spinners
     * @return die entsprechenden Punkte
     */
    private int reform063(String s)
    {
        if (s.equals("teilweise"))
        {
            return 6;
        }
        else if (s.equals("selbstständig"))
        {
            return 3;
        }
        else
        {
            return 0;
        }

    }

    /*
     *
     * @param i nimmt die erzeugten Punkte
     * @return gibt die Assesmentpunkte wieder
     */
    private double mod_1_assPkt(int i)
    {
        double ass = 0;
        switch(i)
        {
            case 2:
            case 3:
                ass = (float) 2.5;
                break;
            case 4:
            case 5:
                ass = 5;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                ass = (float)7.5;
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                ass = 10;
                break;
        }
        return ass;
    }
    private double mod_2_assPkt(int i)
    {
        double ass = 15;
        switch(i)
        {
            case 0:
            case 1:
                ass = (float) 0;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                ass = (float) 3.75;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                ass = (float)7.5;
                break;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                ass = 11.25;
                break;
        }
        return ass;
    }
    private double mod_3_assPkt(int i)
    {
        double ass = 15;
        switch(i)
        {
            case 0:
                ass = (double) 0;
                break;
            case 1:
            case 2:
                ass = 3.75;
                break;
            case 3:
            case 4:
                ass = 7.5;
                break;
            case 5:
            case 6:
                ass = 11.25;
                break;
        }
        return ass;
    }
    private double mod_4_assPkt(int i)
    {
        if(i<3)
        {
            return 0;
        }
        if(i>2&&i<8)
        {
            return 10;
        }
        if(i>7&&i<19)
        {
            return 20;
        }
        if(i>18&&i<37)
        {
            return 30;
        }
        if(i>36)
        {
            return 40;
        }
        return 40;
    }
    private double modul_5_assPkt(int i)
    {
        if(i<1)
        {
            return 0;
        }
        if(i>0&&i<2)
        {
            return 5;
        }
        if(i>1&&i<4)
        {
            return 10;
        }
        if(i>3&&i<6)
        {
            return 15;
        }
        if(i>5)
        {
            return 20;
        }
        return 20;
    }
    private double mod_6_assPkt(int i)
    {
        if(i<1)
        {
            return 0;
        }
        if(i>0&&i<4)
        {
            return 3.75;
        }
        if(i>3&&i<7)
        {
            return 7.5;
        }
        if(i>6&&i<12)
        {
            return 11.25;
        }
        if(i>11)
        {
            return 15;
        }
        return 15;
    }

    public static int monthfor()
    {
        return (month % 12);
    }

    /**
     *
     * @return gibt die Assesmentpunkte für Modul 1 zurück
     */
    public static String gib1()
    {
        String strI = "" + modul_1_assPkt;
        return strI ;
    }
    public static String gib2()
    {
        String strI = "" + modul_2_assPkt;
        return strI ;
    }
    public static String gib3()
    {
        String strI = "" + modul_3_assPkt;
        return strI ;
    }
    public static String gib4()
    {
        String strI = "" + modul_4_assPkt;
        return strI ;
    }
    public static String gib5()
    {
        String strI = "" + modul_5_assPkt;
        return strI ;
    }
    public static String gib6()
    {
        String strI = "" + modul_6_assPkt;
        return strI ;
    }


    public boolean SpinnerAusgewaelt(LinkedList<Spinner> spin)
    {
        boolean b = true;
        for (Spinner sp : spin) {
            if (sp.getSelectedItem().toString().equals("Bitte auswählen")) {
                b = false;
            }
        }
        return b;
    }
    public static boolean NamenAusgewaelt(LinkedList<String> str)
    {
        boolean b = true;
        for(String s: str)
        {
            if(s.equals(""))
            {
                b = false;
            }
        }
        return b;
    }
    private LinkedList<String> spinnerToString(LinkedList<Spinner> spin)
    {
        LinkedList<String> str = new LinkedList<>();
        for (Spinner spi : spin)
        {
            str.add(spi.getSelectedItem().toString());
        }
        return str;
    }



    public void infoPopup(String str, Context c)
    {
        i = new Intent(c, Info_Text.class);
        i.putExtra("key", str);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(i);
    }

    public static void age()
    {
        age=0;
        age = heuteY - gebY;
        if(heuteM < gebM ||((gebM==heuteM)&&gebT>heuteT)){
            --age;
        }

    }

    public static void ageMonth()
    {
        month = age*12;
        if(gebM<=heuteM && gebT<=heuteT)
        {
            month = month +(heuteM - gebM);
        }
        else if (gebM<heuteM && gebT>heuteT)
        {
            month = month +(heuteM - gebM - 1);
        }
        else if (gebM>heuteM && gebT<=heuteT)
        {
            month = month +(heuteM - gebM + 12);
        }
        else if (gebM>=heuteM && gebT>heuteT)
        {
            month = month +(heuteM - gebM + 11);
        }
    }


    public void Modul_1_Kinder()
    {
        modul1_gleich();
        if(Save.m105==3)
        {
            modul_1_punkte += 1;
        }
        if(Save.m105==4)
        {
            modul_1_punkte += 2;
        }
        modul_1_assPkt = mod_1_assPkt(modul_1_punkte);



    }
    public void Modul_1_Erwachsene()
    {
        modul1_gleich();
        if(Save.m105==2)
        {
            modul_1_punkte += 1;
        }
        if(Save.m105==3)
        {
            modul_1_punkte += 2;
        }
        if(Save.m105==4)
        {
            modul_1_punkte += 3;
        }
        modul_1_assPkt = mod_1_assPkt(modul_1_punkte);
    }
    private void modul1_gleich()
    {
        modul_1_punkte = 0;

        if(Save.m101==2)
        {
            modul_1_punkte += 1;
        }
        if(Save.m101==3)
        {
            modul_1_punkte += 2;
        }
        if(Save.m101==4)
        {
            modul_1_punkte += 3;
        }
        if(Save.m102==2)
        {
            modul_1_punkte += 1;
        }
        if(Save.m102==3)
        {
            modul_1_punkte += 2;
        }
        if(Save.m102==4)
        {
            modul_1_punkte += 3;
        }
        if(Save.m103==2)
        {
            modul_1_punkte += 1;
        }
        if(Save.m103==3)
        {
            modul_1_punkte += 2;
        }
        if(Save.m103==4)
        {
            modul_1_punkte += 3;
        }
        if(Save.m104==2)
        {
            modul_1_punkte += 1;
        }
        if(Save.m104==3)
        {
            modul_1_punkte += 2;
        }
        if(Save.m104==4)
        {
            modul_1_punkte += 3;
        }
    }
    public void Modul_2_24()
    {
        modul_2_punkte = 0;

        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m202==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 1;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_2430()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m202==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert 2 2.3 entfällt
        //abgeändert 2
        if(Save.m204==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m206==4)
        {
            modul_2_punkte += 1;
        }
        //abgeändert 3 2.7 entfällt komplett
        //geändert 3 2.8 entfällt komplett
        //abgeändert
        if(Save.m209==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert
        if(Save.m210==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert
        if(Save.m211==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 2;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_3036()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m202==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert 2
        if(Save.m203==4)
        {
            modul_2_punkte += 1;
        }
        //abgeändert 2
        if(Save.m204==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m206==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert 3 2.7 entfällt komplett
        //geändert 2
        if(Save.m208==4)
        {
            modul_2_punkte += 1;
        }
        //abgeändert
        if(Save.m209==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m211==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 2;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_3648()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m202==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert 2
        if(Save.m203==4)
        {
            modul_2_punkte += 1;
        }
        //abgeändert
        if(Save.m204==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m206==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert 3 2.7 entfällt komplett
        //geändert 2
        if(Save.m208==4)
        {
            modul_2_punkte += 1;
        }
        //abgeändert
        if(Save.m209==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m211==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 2;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_4854()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m202==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert 2
        if(Save.m203==4)
        {
            modul_2_punkte += 1;
        }
        //abgeändert
        if(Save.m204==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m206==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert 2
        if(Save.m207==4)
        {
            modul_2_punkte += 1;
        }
        //geändert 2
        if(Save.m208==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m211==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 3;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_5460()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m202==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert 2
        if(Save.m203==4)
        {
            modul_2_punkte += 1;
        }
        //abgeändert
        if(Save.m204==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m206==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert 2
        if(Save.m207==4)
        {
            modul_2_punkte += 1;
        }
        //geändert 2
        if(Save.m208==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m211==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 3;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_6066()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m202==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert
        if(Save.m203==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m203==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert
        if(Save.m204==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m206==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m207==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m207==4)
        {
            modul_2_punkte += 2;
        }
        //geändert 2
        if(Save.m208==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m211==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 3;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_6672()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m202==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 2;
        }
        //abgeändert
        if(Save.m203==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m203==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m206==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m207==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m207==4)
        {
            modul_2_punkte += 2;
        }
        //geändert 2
        if(Save.m208==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m211==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 3;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_7278()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m202==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m203==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m203==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m206==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m207==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m207==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m207==4)
        {
            modul_2_punkte += 3;
        }
        //geändert 2
        if(Save.m208==4)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m211==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 3;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_7884()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m202==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 3;
        }
        //abgeändert
        if(Save.m203==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m203==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m206==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m207==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m207==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m207==4)
        {
            modul_2_punkte += 3;
        }
        //geändert
        if(Save.m208==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m208==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m211==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 3;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_84120()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m202==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m203==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m203==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m203==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m204==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m206==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m207==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m207==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m207==4)
        {
            modul_2_punkte += 3;
        }
        //geändert
        if(Save.m208==3)
        {
            modul_2_punkte += 1;
        }
        if(Save.m208==4)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m211==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 3;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_2_120()
    {
        modul_2_punkte = 0;
        if(Save.m201==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m201==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m201==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m202==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m202==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m202==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m203==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m203==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m203==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m204==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m204==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m204==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m205==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m205==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m205==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m206==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m206==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m206==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m207==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m207==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m207==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m208==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m208==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m208==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m209==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m209==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m209==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m210==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m210==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m210==4)
        {
            modul_2_punkte += 3;
        }
        if(Save.m211==2)
        {
            modul_2_punkte += 1;
        }
        if(Save.m211==3)
        {
            modul_2_punkte += 2;
        }
        if(Save.m211==4)
        {
            modul_2_punkte += 3;
        }
        modul_2_assPkt = mod_2_assPkt(modul_2_punkte);
    }
    public void Modul_4_uKinder()
    {
        modul_4_punkte = 0;
        if(Save.m4k==2)
        {
            modul_4_punkte = 20;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);

    }

    public void Modul_4_1820()
    {
        modul_4_punkte = 0;
        //abgeändert 3 4.1 entfällt
        //abgeänder
        if(Save.m402==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 3 4.3 entfällt
        //abgeändert 3 4.4 entfällt
        //abgeändert
        if(Save.m405==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m406==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 3 4.7 entfällt
        //abgeändert 2
        if(Save.m408==4)
        {
            modul_4_punkte += 3;
        }
        //abgeändert
        if(Save.m409==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 4;
        }
        //abgeändert
        if(Save.m410==4)
        {
            modul_4_punkte += 2;
        }
        //4.11 entfällt
        //4.12 entfällt
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_2024()
    {
        modul_4_punkte = 0;
        //abgeändert 3 4.1 entfällt
        //abgeänder
        if(Save.m402==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 3 4.3 entfällt
        //abgeändert 3 4.4 entfällt
        //abgeändert
        if(Save.m405==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m406==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 3 4.7 entfällt
        //abgeändert
        if(Save.m408==3)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 6;
        }
        //abgeändert
        if(Save.m409==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 4;
        }
        //abgeändert
        if(Save.m410==4)
        {
            modul_4_punkte += 2;
        }
        //4.11 entfällt
        //4.12 entfällt
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_2430()
    {
        modul_4_punkte = 0;
        //abgeändert 2
        if(Save.m401==4)
        {
            modul_4_punkte += 1;
        }
        //abgeänder
        if(Save.m402==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m403==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 3 4.4 entfällt
        //abgeändert
        if(Save.m405==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m406==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m407==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert
        if(Save.m408==3)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 6;
        }
        if(Save.m409==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 6;
        }
        //abgeändert
        if(Save.m410==4)
        {
            modul_4_punkte += 2;
        }
        //4.11 entfällt
        //4.12 entfällt
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_3042()
    {
        modul_4_punkte = 0;
        //abgeändert 2
        if(Save.m401==4)
        {
            modul_4_punkte += 1;
        }
        //abgeänder
        if(Save.m402==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m403==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 3 4.4 entfällt
        //abgeändert
        if(Save.m405==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m406==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m407==4)
        {
            modul_4_punkte += 1;
        }
        if(Save.m408==2)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==3)
        {
            modul_4_punkte += 6;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 9;
        }
        if(Save.m409==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 6;
        }
        //abgeändert
        if(Save.m410==4)
        {
            modul_4_punkte += 2;
        }
        //4.11 entfällt
        //4.12 entfällt
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_4248()
    {
        modul_4_punkte = 0;
        //abgeändert 2
        if(Save.m401==4)
        {
            modul_4_punkte += 1;
        }
        //abgeänder
        if(Save.m402==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m402==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert 2
        if(Save.m403==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert 2
        if(Save.m404==4)
        {
            modul_4_punkte += 1;
        }
        //abgeändert
        if(Save.m405==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m405==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m406==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m406==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert 2
        if(Save.m407==4)
        {
            modul_4_punkte += 1;
        }
        if(Save.m408==2)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==3)
        {
            modul_4_punkte += 6;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 9;
        }
        if(Save.m409==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 6;
        }
        //abgeändert
        if(Save.m410==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m410==4)
        {
            modul_4_punkte += 4;
        }
        //4.11 entfällt
        //4.12 entfällt
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_4860()
    {
        modul_4_punkte = 0;
        //abgeändert
        if(Save.m401==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m401==4)
        {
            modul_4_punkte += 2;
        }
        //abgeänder
        if(Save.m402==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m402==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m403==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m403==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m404==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m404==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m405==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m405==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m406==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m406==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert 2
        if(Save.m407==4)
        {
            modul_4_punkte += 1;
        }
        if(Save.m408==2)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==3)
        {
            modul_4_punkte += 6;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 9;
        }
        if(Save.m409==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 6;
        }
        //abgeändert
        if(Save.m410==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m410==4)
        {
            modul_4_punkte += 4;
        }
        //4.11 entfällt
        //4.12 entfällt
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_6066()
    {
        modul_4_punkte = 0;
        //abgeändert
        if(Save.m401==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m401==4)
        {
            modul_4_punkte += 2;
        }
        if(Save.m402==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m402==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m402==4)
        {
            modul_4_punkte += 3;
        }
        //abgeändert
        if(Save.m403==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m403==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m404==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m404==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m405==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m405==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m406==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m406==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert 2
        if(Save.m407==4)
        {
            modul_4_punkte += 1;
        }
        if(Save.m408==2)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==3)
        {
            modul_4_punkte += 6;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 9;
        }
        if(Save.m409==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 6;
        }
        //abgeändert
        if(Save.m410==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m410==4)
        {
            modul_4_punkte += 4;
        }
        if(Save.m411==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m411==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m411==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m412==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m412==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m412==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_6672()
    {
        modul_4_punkte = 0;
        //abgeändert
        if(Save.m401==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m401==4)
        {
            modul_4_punkte += 2;
        }
        if(Save.m402==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m402==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m402==4)
        {
            modul_4_punkte += 3;
        }
        //abgeändert
        if(Save.m403==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m403==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m404==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m404==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m405==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m405==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m406==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m406==4)
        {
            modul_4_punkte += 2;
        }
        //abgeändert
        if(Save.m407==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m407==4)
        {
            modul_4_punkte += 2;
        }
        if(Save.m408==2)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==3)
        {
            modul_4_punkte += 6;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 9;
        }
        if(Save.m409==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 6;
        }
        //abgeändert
        if(Save.m410==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m410==4)
        {
            modul_4_punkte += 4;
        }
        if(Save.m411==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m411==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m411==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m412==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m412==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m412==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_7296()
    {
        modul_4_punkte = 0;
        if(Save.m401==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m401==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m401==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m402==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m402==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m402==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m403==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m403==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m403==4)
        {
            modul_4_punkte += 3;
        }
        //entfällt
        if(Save.m404==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m404==4)
        {
            modul_4_punkte += 2;
        }
        if(Save.m405==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m405==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m405==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m406==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m406==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m406==4)
        {
            modul_4_punkte += 3;
        }
        //abgeändert
        if(Save.m407==3)
        {
            modul_4_punkte += 1;
        }
        if(Save.m407==4)
        {
            modul_4_punkte += 2;
        }
        if(Save.m408==2)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==3)
        {
            modul_4_punkte += 6;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 9;
        }
        if(Save.m409==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 6;
        }
        if(Save.m410==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m410==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m410==4)
        {
            modul_4_punkte += 6;
        }
        if(Save.m411==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m411==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m411==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m412==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m412==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m412==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_4_96()
    {
        modul_4_punkte = 0;
        if(Save.m401==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m401==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m401==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m402==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m402==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m402==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m403==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m403==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m403==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m404==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m404==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m404==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m405==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m405==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m405==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m406==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m406==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m406==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m407==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m407==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m407==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==2)
        {
            modul_4_punkte += 3;
        }
        if(Save.m408==3)
        {
            modul_4_punkte += 6;
        }
        if(Save.m408==4)
        {
            modul_4_punkte += 9;
        }
        if(Save.m409==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m409==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m409==4)
        {
            modul_4_punkte += 6;
        }
        if(Save.m410==2)
        {
            modul_4_punkte += 2;
        }
        if(Save.m410==3)
        {
            modul_4_punkte += 4;
        }
        if(Save.m410==4)
        {
            modul_4_punkte += 6;
        }
        if(Save.m411==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m411==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m411==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m412==2)
        {
            modul_4_punkte += 1;
        }
        if(Save.m412==3)
        {
            modul_4_punkte += 2;
        }
        if(Save.m412==4)
        {
            modul_4_punkte += 3;
        }
        if(Save.m413==2)
        {
            modul_4_punkte += 6;
        }
        if(Save.m413==3)
        {
            modul_4_punkte += 3;
        }
        modul_4_assPkt = mod_4_assPkt(modul_4_punkte);
    }
    public void Modul_6_1830()
    {
        modul_6_punkte = 0;
        //abgeändert 3 6.1 entfällt
        //abgeändert 2
        if(Save.m602==4)
        {
            modul_6_punkte += 1;
        }
        //abgeändert 2
        if(Save.m603==4)
        {
            modul_6_punkte += 1;
        }
        //abgeändert 2 6.4 entfällt

        if(Save.m605==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m605==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m605==4)
        {
            modul_6_punkte += 3;
        }
        //abgeändert 2
        if(Save.m606==4)
        {
            modul_6_punkte += 1;
        }
        modul_6_assPkt = mod_6_assPkt(modul_6_punkte);
    }
    public void Modul_6_3036()
    {
        modul_6_punkte = 0;
        //abgeändert 2
        if(Save.m601==4)
        {
            modul_6_punkte += 1;
        }
        //abgeändert 2
        if(Save.m602==4)
        {
            modul_6_punkte += 1;
        }
        //abgeändert 2
        if(Save.m603==4)
        {
            modul_6_punkte += 1;
        }
        //abgeändert 2
        if(Save.m604==4)
        {
            modul_6_punkte += 1;
        }
        if(Save.m605==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m605==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m605==4)
        {
            modul_6_punkte += 3;
        }
        //abgeändert 2
        if(Save.m606==4)
        {
            modul_6_punkte += 1;
        }
        modul_6_assPkt = mod_6_assPkt(modul_6_punkte);
    }
    public void Modul_6_3660()
    {
        modul_6_punkte = 0;
        //abgeändert 2
        if(Save.m601==4)
        {
            modul_6_punkte += 1;
        }
        //abgeändert 2
        if(Save.m602==4)
        {
            modul_6_punkte += 1;
        }
        //abgeändert
        if(Save.m603==3)
        {
            modul_6_punkte += 1;
        }
        if(Save.m603==4)
        {
            modul_6_punkte += 2;
        }
        //abgeändert
        if(Save.m604==3)
        {
            modul_6_punkte += 1;
        }
        if(Save.m604==4)
        {
            modul_6_punkte += 2;
        }
        if(Save.m605==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m605==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m605==4)
        {
            modul_6_punkte += 3;
        }
        //abgeändert
        if(Save.m606==3)
        {
            modul_6_punkte += 1;
        }
        if(Save.m606==4)
        {
            modul_6_punkte += 2;
        }
        modul_6_assPkt = mod_6_assPkt(modul_6_punkte);
    }
    public void Modul_6_6084()
    {
        modul_6_punkte = 0;
        //abgeändert
        if(Save.m601==3)
        {
            modul_6_punkte += 1;
        }
        if(Save.m601==4)
        {
            modul_6_punkte += 2;
        }
        //abgeändert
        if(Save.m602==3)
        {
            modul_6_punkte += 1;
        }
        if(Save.m602==4)
        {
            modul_6_punkte += 2;
        }
        if(Save.m603==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m603==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m603==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m604==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m604==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m604==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m605==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m605==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m605==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m606==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m606==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m606==4)
        {
            modul_6_punkte += 3;
        }
        modul_6_assPkt = mod_6_assPkt(modul_6_punkte);
    }
    public void Modul_6_84132()
    {
        modul_6_punkte = 0;

        if(Save.m601==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m601==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m601==4)
        {
            modul_6_punkte += 3;
        }
        //abgeändert
        if(Save.m602==3)
        {
            modul_6_punkte += 1;
        }
        if(Save.m602==4)
        {
            modul_6_punkte += 2;
        }
        if(Save.m603==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m603==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m603==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m604==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m604==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m604==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m605==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m605==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m605==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m606==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m606==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m606==4)
        {
            modul_6_punkte += 3;
        }
        modul_6_assPkt = mod_6_assPkt(modul_6_punkte);
    }
    public void Modul_6_132()
    {
        modul_6_punkte = 0;

        if(Save.m601==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m601==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m601==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m602==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m602==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m602==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m603==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m603==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m603==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m604==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m604==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m604==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m605==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m605==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m605==4)
        {
            modul_6_punkte += 3;
        }
        if(Save.m606==2)
        {
            modul_6_punkte += 1;
        }
        if(Save.m606==3)
        {
            modul_6_punkte += 2;
        }
        if(Save.m606==4)
        {
            modul_6_punkte += 3;
        }
        modul_6_assPkt = mod_6_assPkt(modul_6_punkte);
    }


}

