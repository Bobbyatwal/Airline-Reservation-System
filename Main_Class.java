
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_Class {

    public static void main(String args[]) throws IOException {
        int[][] first = new int[2][4];
        int[][] economy = new int[20][6];
        ArrayList<String> occupy_first = new ArrayList<>();
        ArrayList<String> occupy_economy = new ArrayList<>();
        ArrayList<String> occupy_first_group = new ArrayList<>();
        ArrayList<String> occupy_economy_group = new ArrayList<>();
        String name = "", clas = "", seat = "";
        // String filename = "Input.txt";

        BufferedReader bf = null;
        try{
            bf = new BufferedReader(new FileReader(args[0]));
            for (int i = 0; i < 2; i++) {
                String Line = bf.readLine();
                String []splits = Line.split(" ");
                for (int j = 0; j < splits.length; j++) {
                    first[i][j] = Integer.parseInt(splits[j]);
                }
            }
            for (int i = 0; i < 20; i++) {
                String Line = bf.readLine();
                String []splits = Line.split(" ");
                for (int j = 0; j < splits.length; j++) {
                    economy[i][j] = Integer.parseInt(splits[j]);
                }
            }
            String Line = bf.readLine();
            while(Line != null){
                String []splits1 = Line.split(": ");
                if(splits1[0].equals("First")){
                    String []splits = splits1[1].split(", ");
                    if(splits.length == 0){
                        for (int i = 0; i < splits[1].length(); i++) {
                           occupy_first.add(splits[i]);
                        }
                    }else if(splits.length > 0){
                        for (int i = 0; i < splits.length; i++) {
                           occupy_first.add(splits[i]);
                        }
                    }
                }
                if(splits1[0].equals("Economy")){
                    String []splits = splits1[1].split(", ");
                    if(splits.length == 0){
                        for (int i = 0; i < splits[1].length(); i++) {
                           occupy_economy.add(splits[i]);
                        }
                    }else if(splits.length > 0){
                        for (int i = 0; i < splits.length; i++) {
                           occupy_economy.add(splits[i]);
                        }
                    }
                }
                if(splits1[0].equals("First_Group")){
                    String []splits = splits1[1].split(", ");
                    if(splits.length == 0){
                        for (int i = 0; i < splits[1].length(); i++) {
                           occupy_first_group.add(splits[i]);
                        }
                    }else if(splits.length > 0){
                        for (int i = 0; i < splits.length; i++) {
                           occupy_first_group.add(splits[i]);
                        }
                    }
                }
                if(splits1[0].equals("Economy_Group")){
                    String []splits = splits1[1].split(", ");
                    if(splits.length == 0){
                        for (int i = 0; i < splits[1].length(); i++) {
                           occupy_economy_group.add(splits[i]);
                        }
                    }else if(splits.length > 0){
                        for (int i = 0; i < splits.length; i++) {
                           occupy_economy_group.add(splits[i]);
                        }
                    }
                }
                Line = bf.readLine();
            }
        }
        catch(FileNotFoundException e){
            File yourFile = new File(args[0]);
            yourFile.createNewFile();
            bf = new BufferedReader(new FileReader(args[0]));
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    first[i][j] = 0;
                }
            }
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 6; j++) {
                    economy[i][j] = 0;
                }
            }
            BufferedWriter bout = new BufferedWriter(new FileWriter(args[0]));
            for (int i = 0; i < 2; i++) {
                bout.write(first[i][0] + " " + first[i][1] + " " + first[i][2] + " " + first[i][3]);
                bout.newLine();
            }
            for (int i = 0; i < 20; i++) {
                if(i != 0){
                    bout.newLine();
                }
                bout.write(economy[i][0] + " " + economy[i][1] + " " + economy[i][2] + " " + economy[i][3] + " " + economy[i][4] + " " + economy[i][5]);
            }
            bout.close();
        }
        finally {
            try {
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(Main_Class.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while(true){
            System.out.println("Add [P]assener");
            System.out.println("Add [G]roup");
            System.out.println("[C]ancel Reservation");
            System.out.println("Print Seating [A]vailability Chart");
            System.out.println("Print [M]anifest");
            System.out.println("[Q]uit");
            Scanner input = new Scanner(System.in);
            switch (input.nextLine()) {
                case "P":
                case "p": {
                    System.out.println("Enter Name:");
                    name = new Scanner(System.in).nextLine();
                    while (name.isEmpty()) {
                        System.out.println("Invalid! Enter valid Name:");
                        name = new Scanner(System.in).nextLine();
                    }
                    System.out.println("Service Class:");
                    clas = new Scanner(System.in).nextLine();
                    while (!clas.equals("First") && !clas.equals("Economy")) {
                        System.out.println("Invalid! Enter valid Service Class:");
                        clas = new Scanner(System.in).nextLine();
                    }
                    System.out.println("Seat Preference:");
                    seat = new Scanner(System.in).nextLine();
                    while (!seat.equals("W") && !seat.equals("C") && !seat.equals("A")) {
                        System.out.println("Invalid! Enter valid Seat Preference:");
                        seat = new Scanner(System.in).nextLine();
                    }
                    int done = 0;
                    if(clas.equals("First") || clas.equals("first")){
                        while(true){
                            if(seat.equals("W")){
                                int indicator=0;
                                for (int i = 0; i < 2; i++) {
                                    for (int j = 0; j < 4; j+=3) {
                                        if(first[i][j] == 0){
                                            first[i][j] = 1;
                                            if(j == 0){
                                                occupy_first.add((i+1) + "A " + name);
                                                System.out.println("Seat Reserved...");
                                                done++;
                                                indicator++;
                                                break;
                                            }else if(j == 1){
                                                occupy_first.add((i+1) + "B " + name);
                                                System.out.println("Seat Reserved...");
                                                done++;
                                                indicator++;
                                                break;
                                            }else if(j == 2){
                                                occupy_first.add((i+1) + "C " + name);
                                                System.out.println("Seat Reserved...");
                                                done++;
                                                indicator++;
                                                break;
                                            }else if(j == 3){
                                                occupy_first.add((i+1) + "D " + name);
                                                System.out.println("Seat Reserved...");
                                                done++;
                                                indicator++;
                                                break;
                                            }
                                        }
                                    }
                                    if(indicator > 0){
                                        break;
                                    }
                                }
                            }
                            else if(seat.equals("C") || seat.equals("A")){
                                int indicator=0;
                                for (int i = 0; i < 2; i++) {
                                    for (int j = 1; j < 3; j++) {
                                        if(first[i][j] == 0){
                                            first[i][j] = 1;
                                            if(j == 0){
                                                occupy_first.add((i+1) + "A " + name);
                                                System.out.println("Seat Reserved...");
                                                done++;
                                                indicator++;
                                                break;
                                            }else if(j == 1){
                                                occupy_first.add((i+1) + "B " + name);
                                                System.out.println("Seat Reserved...");
                                                done++;
                                                indicator++;
                                                break;
                                            }else if(j == 2){
                                                occupy_first.add((i+1) + "C " + name);
                                                System.out.println("Seat Reserved...");
                                                done++;
                                                indicator++;
                                                break;
                                            }else if(j == 3){
                                                occupy_first.add((i+1) + "D " + name);
                                                System.out.println("Seat Reserved...");
                                                done++;
                                                indicator++;
                                                break;
                                            }
                                        }
                                    }
                                    if(indicator > 0){
                                        break;
                                    }
                                }
                            }
                            if(done == 0){
                                System.out.println("No Seat Available...Select Another Seat Preference");
                                seat = new Scanner(System.in).nextLine();
                            }
                            else if(done > 0){
                                break;
                            }
                        }
                    }
                    if(clas.equals("Economy") || clas.equals("economy")){
                        while(true){
                            if(seat.equals("W")){
                                int indicator = 0;
                                for (int i = 0; i < 20; i++) {
                                    for (int j = 0; j < 6; j+=5) {
                                        if(economy[i][j] == 0){
                                            economy[i][j] = 1;
                                            if(j == 0){
                                                occupy_economy.add((i+1) + "A " + name);
                                                System.out.println("Seat Reserved...");
                                                indicator++;
                                                done++;
                                                break;
                                            }else if(j == 5){
                                                occupy_economy.add((i+1) + "F " + name);
                                                System.out.println("Seat Reserved...");
                                                indicator++;
                                                done++;
                                                break;
                                            }
                                        }
                                    }
                                    if(indicator > 0){
                                        break;
                                    }
                                }
                            }
                            else if(seat.equals("C")){
                                int indicator = 0;
                                for (int i = 0; i < 20; i++) {
                                    for (int j = 1; j < 6; j+=3) {
                                        if(economy[i][j] == 0){
                                            economy[i][j] = 1;
                                            if(j == 1){
                                                occupy_economy.add((i+1) + "B " + name);
                                                System.out.println("Seat Reserved...");
                                                indicator++;
                                                done++;
                                                break;
                                            }else if(j == 4){
                                                occupy_economy.add((i+1) + "E " + name);
                                                System.out.println("Seat Reserved...");
                                                indicator++;
                                                done++;
                                                break;
                                            }
                                        }
                                    }
                                    if(indicator > 0){
                                        break;
                                    }
                                }
                            }
                            else if(seat.equals("A")){
                                int indicator = 0;
                                for (int i = 0; i < 20; i++) {
                                    for (int j = 2; j < 4; j++) {
                                        if(economy[i][j] == 0){
                                            economy[i][j] = 1;
                                            if(j == 2){
                                                occupy_economy.add((i+1) + "C " + name);
                                                indicator++;
                                                done++;
                                                System.out.println("Seat Reserved...");
                                                break;
                                            }else if(j == 3){
                                                occupy_economy.add((i+1) + "D " + name);
                                                indicator++;
                                                done++;
                                                System.out.println("Seat Reserved...");
                                                break;
                                            }
                                        }
                                    }
                                    if(indicator > 0){
                                        break;
                                    }
                                }
                            }
                            if(done == 0){
                                System.out.println("No Seat Available...Select Another Seat Preference");
                                seat = new Scanner(System.in).nextLine();
                            }
                            else if(done > 0){
                                break;
                            }
                        }
                    }
                    break;
                }
                case "G": {
                    System.out.println("Enter Group Name:");
                    String group = new Scanner(System.in).nextLine();
                    while (group.isEmpty()) {
                        System.out.println("Invalid! Enter valid Name:");
                        group = new Scanner(System.in).nextLine();
                    }
                    ArrayList<String> arr = new ArrayList<>();
                    System.out.println("Enter Group Members Name:");
                    String g_mbr_name = new Scanner(System.in).nextLine();
                    String[] split = g_mbr_name.split(",");
                    for (int i = 0; i < split.length; i++) {
                        arr.add(split[i]);
                    }
                    System.out.println("Service Class:");
                    clas = new Scanner(System.in).nextLine();
                    while (!clas.equals("First") && !clas.equals("Economy")) {
                        System.out.println("Invalid! Enter valid Service Class:");
                        clas = new Scanner(System.in).nextLine();
                    }
                    int count = arr.size(), a=0, countseat1 = 0;
                    if(clas.equals("First")){
                        for (int i = 0; i < 2; i++) {
                            int countseat = 0;
                            for (int j = 0; j < 4; j++) {
                                if(first[i][j] == 0){
                                    countseat++;
                                    if(countseat == count){
                                        for (int k = i; k < 2; k++) {
                                            if(countseat1 == arr.size()){
                                                break;
                                            }
                                            for (int l = 0; l <= j; l++) {
                                                if(first[k][l] == 0){
                                                    first[k][l] = 1;
                                                    if(k == 0){
                                                        occupy_first_group.add((i+1) + "A " + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }else if(k == 1){
                                                        occupy_first_group.add((i+1) + "B " + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }else if(k == 2){
                                                        occupy_first_group.add((i+1) + "C " + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }else if(k == 3){
                                                        occupy_first_group.add((i+1) + "D " + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            if(countseat == count){
                                break;
                            }
                            if(countseat != count){
                                System.out.println("Not Enough Seat Available...");
                            }
                        }
                    } else if(clas.equals("Economy")){
                        int countseat = 0;
                        for (int i = 0; i < 20; i++) {
                            for (int j = 0; j < 6; j++) {
                                if(economy[i][j] == 0){
                                    countseat++;
                                    if(countseat == count){
                                        for (int k = 0; k < 20; k++) {
                                            if(countseat1 == arr.size()){
                                                break;
                                            }
                                            for (int l = 0; l < 6; l++) {
                                                if(countseat1 == arr.size()){
                                                    break;
                                                }
                                                if(economy[k][l] == 0){
                                                    economy[k][l] = 1;
                                                    if(l == 0){
                                                        occupy_economy_group.add((k+1) + "A " + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }else if(l == 1){
                                                        occupy_economy_group.add((k+1) + "B" + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }else if(l == 2){
                                                        occupy_economy_group.add((k+1) + "C" + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }else if(l == 3){
                                                        occupy_economy_group.add((k+1) + "D" + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }else if(l == 4){
                                                        occupy_economy_group.add((k+1) + "E" + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }else if(l == 5){
                                                        occupy_economy_group.add((k+1) + "F" + arr.get(a++)+"("+group+")");
                                                        System.out.println("Seat Reserved...");
                                                        countseat1++;
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            if(countseat == count){
                                break;
                            }
                        }
                        if(countseat != count){
                            System.out.println("Not Enough Seat Available...");
                        }
                    }
                    break;
                }
                case "C": {
                    System.out.println("Cancellation is for an Individual or a Group");
                    String cancellation = new Scanner(System.in).nextLine();
                    while (!cancellation.equals("Individual") && !cancellation.equals("individual") && !cancellation.equals("Group") && !cancellation.equals("group")) {
                        System.out.println("Invalid! Enter valid Input");
                        cancellation = new Scanner(System.in).nextLine();
                    }
                    if (cancellation.equals("Individual") || cancellation.equals("individual")) {
                        System.out.println("Enter Name:");
                        name = new Scanner(System.in).nextLine();
                        for (int i = 0; i < occupy_first.size(); i++) {
                            String []split = occupy_first.get(i).split(" ");
                            if(split[1].equals(name)){
                                int as = Integer.valueOf(String.valueOf(split[0].charAt(0)));
                                System.out.println(as);
                                for (int j = as; j <= 2; j++) {
                                    if(split[0].charAt(1) == 'A'){
                                        if(i > 0){
                                            first[i-1][0] = 0;
                                        }else{
                                            first[i][0] = 0;
                                        }
                                        occupy_first.remove(i);
                                    }
                                    if(split[0].charAt(1) == 'B'){
                                        if(i > 0){
                                            first[i-1][1] = 0;
                                        }else{
                                            first[i][1] = 0;
                                        }
                                        occupy_first.remove(i);
                                    }
                                    if(split[0].charAt(1) == 'C'){
                                        if(i > 0){
                                            first[i-1][2] = 0;
                                        }else{
                                            first[i][2] = 0;
                                        }
                                        occupy_first.remove(i);
                                    }
                                    if(split[0].charAt(1) == 'D'){
                                        if(i > 0){
                                            first[i-1][3] = 0;
                                        }else{
                                            first[i][3] = 0;
                                        }
                                        occupy_first.remove(i);
                                    }
                                    break;
                                }
                                System.out.println("Cancelled");
                                break;
                            }
                        }
                        for (int i = 0; i < occupy_economy.size(); i++) {
                            String []split = occupy_economy.get(i).split(" ");
                            if(split[1].equals(name)){
                                int as = Integer.valueOf(String.valueOf(split[0].charAt(0)));
                                System.out.println(as);
                                for (int j = as; j <= 2; j++) {
                                    if(split[0].charAt(1) == 'A'){
                                        if(i > 0){
                                            economy[i-1][0] = 0;
                                        }else{
                                            economy[i][0] = 0;
                                        }
                                        occupy_economy.remove(i);
                                    }
                                    if(split[0].charAt(1) == 'B'){
                                        if(i > 0){
                                            economy[i-1][1] = 0;
                                        }else{
                                            economy[i][1] = 0;
                                        }
                                        occupy_economy.remove(i);
                                    }
                                    if(split[0].charAt(1) == 'C'){
                                        if(i > 0){
                                            economy[i-1][2] = 0;
                                        }else{
                                            economy[i][2] = 0;
                                        }
                                        occupy_economy.remove(i);
                                    }
                                    if(split[0].charAt(1) == 'D'){
                                        if(i > 0){
                                            economy[i-1][3] = 0;
                                        }else{
                                            economy[i][3] = 0;
                                        }
                                        occupy_economy.remove(i);
                                    }
                                    if(split[0].charAt(1) == 'E'){
                                        if(i > 0){
                                            economy[i-1][4] = 0;
                                        }else{
                                            economy[i][4] = 0;
                                        }
                                        occupy_economy.remove(i);
                                    }
                                    if(split[0].charAt(1) == 'F'){
                                        if(i > 0){
                                            economy[i-1][5] = 0;
                                        }else{
                                            economy[i][5] = 0;
                                        }
                                        occupy_economy.remove(i);
                                    }
                                    break;
                                }
                                System.out.println("Cancelled");
                                break;
                            }
                        }
                    } else if (cancellation.equals("Group") || cancellation.equals("group")) {
                        int flag=0;
                        System.out.println("Enter Group Name:");
                        String group = new Scanner(System.in).nextLine();
                        for (int i = 0; i < occupy_first_group.size(); i++) {
                            String name1 = occupy_first_group.get(i);
                            String []splits = name1.split("\\(");
                            String []splitss = splits[1].split("\\)");
                            if(splitss[0].equals(group)){
                                int size = occupy_first_group.size();
                                for (int j = i; j < occupy_first_group.size(); j++) {
                                    name1 = occupy_first_group.get(i);
                                    splits = name1.split("\\(");
                                    splitss = splits[1].split("\\)");
                                    String groupname = splitss[0];
                                    occupy_first_group.remove(j);
                                    flag = 1;
                                    int a = Integer.valueOf(String.valueOf(splits[0].charAt(0)));
                                    if(String.valueOf(splits[0].charAt(1)).equals("A")){
                                        first[a][1] = 0;
                                    }else if(String.valueOf(splits[0].charAt(1)).equals("B")){
                                        first[a][2] = 0;
                                    }else if(String.valueOf(splits[0].charAt(1)).equals("C")){
                                        first[a][3] = 0;
                                    }else if(String.valueOf(splits[0].charAt(1)).equals("D")){
                                        first[a][4] = 0;
                                    }
                                    j--;
                                }
                            }
                        }
                        for (int i = 0; i < occupy_economy_group.size(); i++) {
                            if(flag > 0){
                                break;
                            }
                            String name1 = occupy_economy_group.get(i);
                            String []splits = name1.split("\\(");
                            String []splitss = splits[1].split("\\)");
                            if(splitss[0].equals(group)){
                                int size = occupy_economy_group.size();
                                for (int j = i; j < occupy_economy_group.size(); j++) {
                                    name1 = occupy_economy_group.get(i);
                                    splits = name1.split("\\(");
                                    String []seatno = splits[0].split(" ");
                                    int a = 0;
                                    if(seatno[0].length() == 2){
                                        a = Integer.valueOf(String.valueOf(seatno[0].charAt(0)));
                                    }else if(seatno[0].length() == 3){
                                        String aaa = String.valueOf(seatno[0].charAt(0))+String.valueOf(seatno[0].charAt(1));
                                        a = Integer.parseInt(aaa);
                                    }

                                    splitss = splits[1].split("\\)");
                                    String groupname = splitss[0];
                                    if(group.equals(groupname)){
                                        occupy_economy_group.remove(j);
                                        int aa = seatno[0].length();
                                        if(String.valueOf(splits[0].charAt(aa-1)).equals("A") || String.valueOf(splits[0].charAt(aa-1)).equals("a")){
                                            economy[a-1][0] = 0;
                                        }else if(String.valueOf(seatno[0].charAt(aa-1)).equals("B")){
                                            economy[a-1][1] = 0;
                                        }else if(String.valueOf(seatno[0].charAt(aa-1)).equals("C")){
                                            economy[a-1][2] = 0;
                                        }else if(String.valueOf(seatno[0].charAt(aa-1)).equals("D")){
                                            economy[a-1][3] = 0;
                                        }else if(String.valueOf(seatno[0].charAt(aa-1)).equals("E")){
                                            economy[a-1][4] = 0;
                                        }else if(String.valueOf(seatno[0].charAt(aa-1)).equals("F")){
                                            economy[a-1][5] = 0;
                                        }
                                        j--;
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
                case "A":
                case "a":{
                    int s=0;
                    System.out.println("Enter the Service Class:");
                    clas = new Scanner(System.in).nextLine();
                    if(clas.equals("First") || clas.equals("first")){
                        for (int i = 0; i < 2; i++) {
                            s=0;
                            System.out.println("");
                            for (int j = 0; j < 4; j++) {
                                if(first[i][j] == 0){
                                    if(j+1 == 1){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "A, ");
                                            s++;
                                        }else{
                                            System.out.print("A, ");
                                        }
                                    }else if(j+1 == 2){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "B, ");
                                            s++;
                                        }else{
                                            System.out.print("B, ");
                                        }
                                    }else if(j+1 == 3){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "C, ");
                                            s++;
                                        }else{
                                            System.out.print("C, ");
                                        }
                                    }else if(j+1 == 4){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "D, ");
                                            s++;
                                        }else{
                                            System.out.print("D");
                                        }
                                    }
                                }
                            }
                        }
                        System.out.println("");
                    }else if(clas.equals("Economy") || clas.equals("economy")){
                        for (int i = 0; i < 20; i++) {
                            s=0;
                            System.out.println("");
                            for (int j = 0; j < 6; j++) {
                                if(economy[i][j] == 0){
                                    if(j+1 == 1){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "A, ");
                                            s++;
                                        }else{
                                            System.out.print("A, ");
                                        }
                                    }else if(j+1 == 2){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "B, ");
                                            s++;
                                        }else{
                                            System.out.print("B, ");
                                        }
                                    }else if(j+1 == 3){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "C, ");
                                            s++;
                                        }else{
                                            System.out.print("C, ");
                                        }
                                    }else if(j+1 == 4){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "D, ");
                                            s++;
                                        }else{
                                            System.out.print("D, ");
                                        }
                                    }else if(j+1 == 5){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "E, ");
                                            s++;
                                        }else{
                                            System.out.print("E, ");
                                        }
                                    }else if(j+1 == 6){
                                        if(s == 0){
                                            System.out.print((i+1) + ": " + "F, ");
                                            s++;
                                        }else{
                                            System.out.print("F");
                                        }
                                    }
                                }
                            }
                        }
                        System.out.println("");
                    }
                    break;
                }
                case "M":
                case "m":{
                    int s=0;
                    System.out.println("Enter the Service Class:");
                    clas = new Scanner(System.in).nextLine();
					System.out.println("Individual or Group");
					String ssa = new Scanner(System.in).nextLine();
                    if(clas.equals("First") || clas.equals("first")){
                        for (int i = 0; i < 2; i++) {
                            s=0;
                            for (int j = 0; j < 4; j++) {
                                if(first[i][j] == 1){
                                    if(j+1 == 1){
										if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_first.size(); k++) {
												String a = occupy_first.get(k).charAt(0)+""+occupy_first.get(k).charAt(1)+"";
												if(a.equals((i+1)+"A")){
													System.out.print(occupy_first.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_first_group.size(); k++) {
												String a = occupy_first_group.get(k).charAt(0)+""+occupy_first_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"A")){
													System.out.print(occupy_first_group.get(0));
												}
											}
										}
                                    }else if(j+1 == 2){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_first.size(); k++) {
												String a = occupy_first.get(k).charAt(0)+""+occupy_first.get(k).charAt(1)+"";
												if(a.equals((i+1)+"B")){
													System.out.print(occupy_first.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_first_group.size(); k++) {
												String a = occupy_first_group.get(k).charAt(0)+""+occupy_first_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"B")){
													System.out.print(occupy_first_group.get(0));
												}
											}
										}
                                    }else if(j+1 == 3){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_first.size(); k++) {
												String a = occupy_first.get(k).charAt(0)+""+occupy_first.get(k).charAt(1)+"";
												if(a.equals((i+1)+"C")){
													System.out.print(occupy_first.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_first_group.size(); k++) {
												String a = occupy_first_group.get(k).charAt(0)+""+occupy_first_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"C")){
													System.out.print(occupy_first_group.get(0));
												}
											}
										}
                                    }else if(j+1 == 4){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_first.size(); k++) {
												String a = occupy_first.get(k).charAt(0)+""+occupy_first.get(k).charAt(1)+"";
												if(a.equals((i+1)+"D")){
													System.out.print(occupy_first.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_first_group.size(); k++) {
												String a = occupy_first_group.get(k).charAt(0)+""+occupy_first_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"D")){
													System.out.print(occupy_first_group.get(0));
												}
											}
										}
                                    }
                                }
                            }
                        }
                        System.out.println("");
                    }else if(clas.equals("Economy") || clas.equals("economy")){
                        for (int i = 0; i < 20; i++) {
                            s=0;
                            for (int j = 0; j < 6; j++) {
                                if(economy[i][j] == 1){
                                    if(j+1 == 1){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_economy.size(); k++) {
												String a = occupy_economy.get(k).charAt(0)+""+occupy_economy.get(k).charAt(1)+"";
												if(a.equals((i+1)+"A")){
													System.out.print(occupy_economy.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_economy_group.size(); k++) {
												String a = occupy_economy_group.get(k).charAt(0)+""+occupy_economy_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"A")){
													System.out.print(occupy_economy_group.get(0));
												}
											}
										}
                                    }else if(j+1 == 2){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_economy.size(); k++) {
												String a = occupy_economy.get(k).charAt(0)+""+occupy_economy.get(k).charAt(1)+"";
												if(a.equals((i+1)+"B")){
													System.out.print(occupy_economy.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_economy_group.size(); k++) {
												String a = occupy_economy_group.get(k).charAt(0)+""+occupy_economy_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"B")){
													System.out.print(occupy_economy_group.get(0));
												}
											}
										}
                                    }else if(j+1 == 3){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_economy.size(); k++) {
												String a = occupy_economy.get(k).charAt(0)+""+occupy_economy.get(k).charAt(1)+"";
												if(a.equals((i+1)+"C")){
													System.out.print(occupy_economy.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_economy_group.size(); k++) {
												String a = occupy_economy_group.get(k).charAt(0)+""+occupy_economy_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"C")){
													System.out.print(occupy_economy_group.get(0));
												}
											}
										}
                                    }else if(j+1 == 4){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_economy.size(); k++) {
												String a = occupy_economy.get(k).charAt(0)+""+occupy_economy.get(k).charAt(1)+"";
												if(a.equals((i+1)+"D")){
													System.out.print(occupy_economy.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_economy_group.size(); k++) {
												String a = occupy_economy_group.get(k).charAt(0)+""+occupy_economy_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"D")){
													System.out.print(occupy_economy_group.get(0));
												}
											}
										}
                                    }else if(j+1 == 5){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_economy.size(); k++) {
												String a = occupy_economy.get(k).charAt(0)+""+occupy_economy.get(k).charAt(1)+"";
												if(a.equals((i+1)+"E")){
													System.out.print(occupy_economy.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_economy_group.size(); k++) {
												String a = occupy_economy_group.get(k).charAt(0)+""+occupy_economy_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"E")){
													System.out.print(occupy_economy_group.get(0));
												}
											}
										}
                                    }else if(j+1 == 6){
                                        if(ssa.equals("Individual")){
											for (int k = 0; k < occupy_economy.size(); k++) {
												String a = occupy_economy.get(k).charAt(0)+""+occupy_economy.get(k).charAt(1)+"";
												if(a.equals((i+1)+"F")){
													System.out.print(occupy_economy.get(0));
												}
											}
										}else if(ssa.equals("Group")){
											for (int k = 0; k < occupy_economy_group.size(); k++) {
												String a = occupy_economy_group.get(k).charAt(0)+""+occupy_economy_group.get(k).charAt(1)+"";
												if(a.equals((i+1)+"F")){
													System.out.print(occupy_economy_group.get(0));
												}
											}
										}
                                    }
                                }
                            }
                        }
                        System.out.println("");
                    }
                    break;
                }
                case "Q": {
                    BufferedWriter bout = new BufferedWriter(new FileWriter(args[0]));
                    for (int i = 0; i < 2; i++) {
                        bout.write(first[i][0] + " " + first[i][1] + " " + first[i][2] + " " + first[i][3]);
                        bout.newLine();
                    }
                    for (int i = 0; i < 20; i++) {
                        if(i != 0){
                            bout.newLine();
                        }
                        bout.write(economy[i][0] + " " + economy[i][1] + " " + economy[i][2] + " " + economy[i][3] + " " + economy[i][4] + " " + economy[i][5]);
                    }
                    for (int i = 0; i < occupy_first.size(); i++) {
                        if(i == 0){
                            bout.newLine();
                            bout.write("First: ");
                        }
                        if(i+1 == occupy_first.size()){
                            bout.write(occupy_first.get(i));
                        }else{
                            bout.write(occupy_first.get(i) + ", ");
                        }
                    }
                    for (int i = 0; i < occupy_economy.size(); i++) {
                        if(i == 0){
                            bout.newLine();
                            bout.write("Economy: ");
                        }
                        if(i+1 == occupy_economy.size()){
                            bout.write(occupy_economy.get(i));
                        }else{
                            bout.write(occupy_economy.get(i) + ", ");
                        }
                    }
                    for (int i = 0; i < occupy_first_group.size(); i++) {
                        if(i == 0){
                            bout.newLine();
                            bout.write("First_Group: ");
                        }
                        if(i+1 == occupy_first_group.size()){
                            bout.write(occupy_first_group.get(i));
                        }else{
                            bout.write(occupy_first_group.get(i) + ", ");
                        }
                    }
                    for (int i = 0; i < occupy_economy_group.size(); i++) {
                        if(i == 0){
                            bout.newLine();
                            bout.write("Economy_Group: ");
                        }
                        if(i+1 == occupy_economy_group.size()){
                            bout.write(occupy_economy_group.get(i));
                        }else{
                            bout.write(occupy_economy_group.get(i) + ", ");
                        }
                    }
                    bout.close();
                    System.exit(0);
                }
            }
        }
    }
}
