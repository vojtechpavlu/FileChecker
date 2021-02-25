package io.github.vojtechpavlu.fileChecker.utils;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


/**
 * <i>AUTHOR OF THIS PROJECT IS NOT RESPONSIBLE FOR ANY DAMAGE TO
 * THE USER'S DEVICE CAUSED BY USING THIS SOFTWARE, NO DATA LEAKS
 * OR DATA INTEGRITY DAMAGE.</i>
 *
 * <i>THIS PIECE OF SOFTWARE WAS MADE WITH NO GUARANTEE AND SHOULD
 * NOT BE USED FOR CRITICAL INFRASTRUCTURE OF YOUR APPS. THIS
 * PROJECT WAS CREATED JUST FOR FUN.</i>
 *
 *
 * <p>Class of {@link FileReader} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p></p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 */
public class FileReader {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */




    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */




    /* =========================================================== */
    /* ====== INSTANCE INIT BLOCKS =============================== */




    /* =========================================================== */
    /* ====== STATIC INIT BLOCKS ================================= */





    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    FileReader(File file, String encoding) throws FileNotFoundException, UnsupportedEncodingException {

        new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
    }


    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */




    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */






    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */


    public static String read(File file) throws IOException {

        StringBuilder contentBuilder = new StringBuilder();

        Stream<String> stream = Files.lines(Paths.get(file.toString()),  StandardCharsets.UTF_16);
        stream.forEach(s -> contentBuilder.append(s).append("\n"));

        return contentBuilder.toString();
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */




    /* =========================================================== */
    /* ====== MAIN METHOD ======================================== */


    public static void main(String[] args) throws IOException {
        
        System.out.println(">>> QUICK TEST OF FileReader BEGINS!");

        System.out.println(read(new File("C:\\Users\\Vojta\\Downloads\\Zkouška - průběh + otázky.txt")));
        
        System.out.println(">>> QUICK TEST OF FileReader ENDED SUCCESSFULLY!");
    }


}
