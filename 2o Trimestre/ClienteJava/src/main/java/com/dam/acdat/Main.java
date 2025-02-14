package com.dam.acdat;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JSONException {
        Scanner sc = new Scanner(System.in);
        String id;
        String opcion = "";

        do {
            System.out.println("""
                MENÚ CRUD
                1. Hacer GET
                2. Hacer POST
                3. Hacer PUT
                4. Hacer DELETE
                0. Cerrar programa
                """);
            System.out.print("Introduce una opción: ");
            opcion = sc.next();

            switch (opcion) {
                case "1":
                    GetRequest();
                    break;

                case "2":
                    PostRequest();
                    break;

                case "3":
                    System.out.print("Introduce el ID del empleado/departamento que quieras actualizar: ");
                    id = sc.next();
                    PutRequest(id);
                    break;

                case "4":
                    System.out.print("Introduce el ID del empleado/departamento que quieras borrar: ");
                    id = sc.next();
                    DeleteRequest(id);
                    break;

                case "0":
                    System.out.println("Cerrando el programa");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

            System.out.println();
        } while (!opcion.equals("0"));
    }

    // Petición GET
    public static void GetRequest() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://localhost:8080/" + "api-res/departamentos");

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() == 200) {
                Scanner sc = new Scanner(conn.getInputStream());
                String response = sc.useDelimiter("\\Z").next();
                sc.close();
                JSONArray jsonArray = new JSONArray(response);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    System.out.println(jsonObject.get("id") + " " + jsonObject.get("nombre"));
                }
            } else {
                System.out.println("Falló la conexión.");
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    // Petición POST
    public static void PostRequest() throws JSONException {
        HttpURLConnection conn = null;
        String jsonInputString = new JSONObject().put("id", 1234)
                .put("nombre", "Díez")
                .put("puesto", "Dependiente")
                .put("departamento", new JSONObject()
                        .put("id", "20")
                        .put("nombre", "Marketing")
                        .put("ubicacion", "Barcelona").toString()).toString();
        try {
            URL url = new URL("http://localhost:8080/api-res/empleados");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            if (conn.getResponseCode() == 200) {
                System.out.println("Empleado insertado");
            } else {
                System.out.printf("Fallo en la conexión");

                Scanner sc = new Scanner(conn.getErrorStream());
                String response = sc.useDelimiter("\\Z").next();
                sc.close();

                JSONObject jsonObject = new JSONObject(response).getJSONArray("errors").getJSONObject(0);
                System.out.println(jsonObject.get("defaultMessage"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    // Petición DELETE
    public static void DeleteRequest(String idParaBorrar) {
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://localhost:8080" + "api-res/empleados/" + idParaBorrar);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            if (conn.getResponseCode() == 200) {
                System.out.println("Empleado eliminado");

            } else {
                System.out.println("Fallo en la conexión");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    // Petición PUT
    public static void PutRequest(String idActualizar) throws JSONException {
        HttpURLConnection conn = null;
        String jsonInputString = new JSONObject().put("id", idActualizar)
                .put("nombre", "Messi")
                .put("puesto", "Dependiente")
                .put("departamento", new JSONObject()
                        .put("id", "20")
                        .put("nombre", "Marketing")
                        .put("ubicacion", "Barcelona").toString()).toString();
        try {
            URL url = new URL("http://localhost:8080/api-res/empleados");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            if (conn.getResponseCode() == 200) {
                System.out.println("Empleado actualizado");
            } else {
                System.out.printf("Fallo en la conexión");

                Scanner sc = new Scanner(conn.getErrorStream());
                String response = sc.useDelimiter("\\Z").next();
                sc.close();

                JSONObject jsonObject = new JSONObject(response).getJSONArray("errors").getJSONObject(0);
                System.out.println(jsonObject.get("defaultMessage"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}