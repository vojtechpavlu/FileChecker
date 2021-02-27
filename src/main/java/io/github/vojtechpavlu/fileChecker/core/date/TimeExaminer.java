package io.github.vojtechpavlu.fileChecker.core.date;


import io.github.vojtechpavlu.fileChecker.core.FileCheck;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.sql.Timestamp;
import java.time.LocalDateTime;


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
 * <p>Class of {@link TimeExaminer} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This class is abstract, it can be instantiated by it's
 * descendants only.</p>
 *
 * <p>Instances of this class represents file time providers.
 * It means these instances can read and check the given files
 * by the found dates.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-27
 *
 * @see CreatedBeforeCheck
 */
public abstract class TimeExaminer implements FileCheck {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    private final LocalDateTime time;


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */




    /* =========================================================== */
    /* ====== INSTANCE INIT BLOCKS =============================== */




    /* =========================================================== */
    /* ====== STATIC INIT BLOCKS ================================= */





    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */

    public TimeExaminer(LocalDateTime time) {

        this.time = time;
    }


    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */




    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */





    /* =========================================================== */
    /* ====== ABSTRACT METHODS =================================== */






    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */

    /**
     * <p>Let's you know the time the file was created.</p>
     *
     * @param file              to be examined. Should exist, otherwise it
     *                          throws an exception.
     *
     * @return                  {@link LocalDateTime} instance representing
     *                          the time of file creation
     *
     * @throws IOException      When the given file does not exist or any
     *                          other fatal problem occurs
     */
    public LocalDateTime getDateOfCreation(File file) throws IOException {

        return new Timestamp(Files.readAttributes(
                file.toPath(),
                BasicFileAttributes.class).creationTime().toMillis()).toLocalDateTime();
    }


    /**
     * <p>Let's you know the time the file was modified lastly.</p>
     *
     * @param file              to be examined. Should exist, otherwise it
     *                          throws an exception.
     *
     * @return                  {@link LocalDateTime} instance representing
     *                          the time of file last modification
     *
     * @throws IOException      When the given file does not exist or any
     *                          other fatal problem occurs
     */
    public LocalDateTime getDateOfLastModification(File file) throws IOException {

        return new Timestamp(Files.readAttributes(
                file.toPath(),
                BasicFileAttributes.class).lastModifiedTime().toMillis()).toLocalDateTime();
    }


    /**
     * <p>Let's you know the time the file was accessed lastly.</p>
     *
     * @param file              to be examined. Should exist, otherwise it
     *                          throws an exception.
     *
     * @return                  {@link LocalDateTime} instance representing
     *                          the time of file access
     *
     * @throws IOException      When the given file does not exist or any
     *                          other fatal problem occurs
     */
    public LocalDateTime getDateOfLastAccess(File file) throws IOException {

        return new Timestamp(Files.readAttributes(
                file.toPath(),
                BasicFileAttributes.class).lastAccessTime().toMillis()).toLocalDateTime();
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */


    public LocalDateTime getTime() {

        return this.time;
    }


    /* =========================================================== */
    /* ====== MAIN METHOD ======================================== */


    public static void main(String[] args) throws IOException {
        
        System.out.println(">>> QUICK TEST OF LastModifiedCheck BEGINS!");

        File f = new File("D:\\Seriály\\Dr. House\\Dr. House - 5. serie\\Dr.House 5x09 - Posledni moznost.avi");

        BasicFileAttributes attributes = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
        PosixFileAttributes attr = Files.readAttributes(f.toPath(), PosixFileAttributes.class);
        //attr.
        //attributes.

        
        System.out.println(">>> QUICK TEST OF LastModifiedCheck ENDED SUCCESSFULLY!");
    }


}