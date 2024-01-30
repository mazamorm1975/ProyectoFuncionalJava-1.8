package org.java_12_17;

public class TextApp {

    public static void main(String[] args) {
        TextApp textApp = new TextApp();
        textApp.m1Simple();
        textApp.m2Indentation();
    }

    private void m1Simple() {
        String texto = """
                "Hola mi nombre es 
                Mario Zamora Martinez
                     y vivo
                        en Chicoloapan
                        
                  Edo. De México 29/01/2024
                """;
        System.out.println(texto);
    }

    private void m2Indentation(){
        String page = """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="UTF-8" />
                    <link rel="icon" type="image/svg+xml" href="/vite.svg" />
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <title>Vite + React</title>
                  </head>
                  <body>
                    <div id="root"></div>
                    <script type="module" src="/src/main.jsx"></script>
                  </body>
                </html>            
                """;

        System.out.println(page);

        String json = """
                {
                    "name": "Mario",
                    "edad": 48,
                    "marital Status": married
                }                      
                """;

        System.out.println(json
        );
    }
}
