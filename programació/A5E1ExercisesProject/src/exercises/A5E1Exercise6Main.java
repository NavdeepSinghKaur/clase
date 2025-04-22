package exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class A5E1Exercise6Main {
    public static void main(String[] args) throws IOException {
        boolean endPorgram = false;

        Scanner scanner = new Scanner(System.in);
        File salaries = new File("docs/data_science_jobs_salaries.csv");
        File articles = new File("docs/articles_geeksforgeeks.csv");
        FileReader fr;
        BufferedReader br;

        while (!endPorgram) {
            System.out.println(menuOptions());
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    endPorgram = true;
                    break;

                case 1:
                    fr = new FileReader(salaries);
                    br = new BufferedReader(fr);
                    String devSalaries = br.readLine();

                    System.out.println(option1(devSalaries, br));
                    break;

                case 2:
                    fr = new FileReader(salaries);
                    br = new BufferedReader(fr);
                    String research_and_3d = br.readLine();

                    System.out.println(option2(research_and_3d, br));

                    break;

                case 3:
                    HashMap<String, Integer> months = monthsMap();

                    fr = new FileReader(articles);
                    br = new BufferedReader(fr);
                    String getModifiedArticles = br.readLine();

                    option3(getModifiedArticles, months, br);

                    break;

                case 4:
                    fr = new FileReader(articles);
                    br = new BufferedReader(fr);
                    String getArticles = br.readLine();

                    option4(getArticles, br);

                    break;

                default:
                    System.out.println("Has elegit una opció invàlida. Torna a intentar-ho.");
            }
        }
    }

    private static void option4(String getArticles, BufferedReader br) throws IOException {
        while (getArticles != null) {
            String[] allArticles = getArticles.split(",");

            if (allArticles[0].toLowerCase().contains("java") ||
                allArticles[0].toLowerCase().contains("python") ||
                allArticles[0].toLowerCase().contains("c++") ||
                allArticles[0].toLowerCase().contains("sql")) {
                System.out.println(allArticles[0]);
            }
            getArticles = br.readLine();
        }
    }

    private static void option3(String getModifiedArticles, HashMap<String, Integer> months, BufferedReader br) throws IOException {

        while (getModifiedArticles != null) {
            String[] getDate = getModifiedArticles
                                .replace("\"", "")
                                .split(",");

            if (getDate.length > 3) {
                String[] dayAndMonth = getDate[2].split(" ");
                int year;
                String month = "";
                try {
                    month = dayAndMonth[1];
                    year = Integer.parseInt(getDate[3].trim());
                    switch (year) {
                        case 2019:
                            if (months.get(month.toLowerCase()) >= 11) {
                                if (months.get(month.toLowerCase()) == 11 && Integer.parseInt(dayAndMonth[0]) >= 5) {
                                    System.out.println(getDate[4] + " (" + dayAndMonth[0] + "/" + dayAndMonth[1] + "/" + year + ")");
                                } else if (months.get(month.toLowerCase()) > 11) {
                                    System.out.println(getDate[4] + " (" + dayAndMonth[0] + "/" + dayAndMonth[1] + "/" + year + ")");
                                }
                            }
                            break;

                        case 2020:
                            System.out.println(getDate[4] + " (" + dayAndMonth[0] + "/" + dayAndMonth[1] + "/" + year + ")");
                            break;

                        case 2021:
                            if (months.get(month.toLowerCase()) == 1 && Integer.parseInt(dayAndMonth[0]) <= 27) {
                                System.out.println(getDate[4] + " (" + dayAndMonth[0] + "/" + dayAndMonth[1] + "/" + year + ")");
                            }
                            break;
                    }
                } catch (Exception _) {}

            }
            getModifiedArticles = br.readLine();
        }

    }

    private static HashMap<String, Integer> monthsMap() {
        HashMap<String, Integer> months = new HashMap<>();
        months.put("Jan", 1);
        months.put("Feb", 2);
        months.put("Mar", 3);
        months.put("Apr", 4);
        months.put("May", 5);
        months.put("Jun", 6);
        months.put("Jul", 7);
        months.put("Aug", 8);
        months.put("Sep", 9);
        months.put("Oct", 10);
        months.put("Nov", 11);
        months.put("Dec", 12);
        return months;
    }

    private static String option2(String researchAnd3D, BufferedReader br) throws IOException {
        String selectedJobs = "";
        while (researchAnd3D != null) {
            String[] jobs = researchAnd3D.split(",");
            if (jobs[3].toLowerCase().contains("3d") || jobs[3].toLowerCase().contains("research")) {
                selectedJobs += researchAnd3D + "\n";
            }
            researchAnd3D = br.readLine();
        }

        return selectedJobs;
    }

    private static String option1(String devSalaries, BufferedReader br) throws IOException {
        String salaries = "";
        while (devSalaries != null) {
            String[] salary = devSalaries.split(",");
            if (salary[4].length() > 5 && salary[5].equals("EUR")) {
                for (String s : salary) {
                    salaries += s + " ";
                }
                salaries += "\n";
            }
            devSalaries = br.readLine();
        }

        return salaries;
    }

    public static String menuOptions() {
        return """
                ---- Gestió dades del camp informàtic ----
                0. Sortir
                1. Consultar els salaris amb més de 5 xifres en €
                2. Consultar els salaris dels treballs relacionats amb "3D" o "Research"
                3. Consultar els articles modificats entre el 05/11/2019 i el 27/01/2021
                4. Comptabilitzar quants articles parlen de JAVA, C++, Python i SQL
                
                Opció:
                """;
    }
}
