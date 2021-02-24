package io.github.vojtechpavlu.fileChecker.crawlers;


import io.github.vojtechpavlu.fileChecker.containers.NOTContainer;
import io.github.vojtechpavlu.fileChecker.core.CanWriteCheck;

import java.io.File;


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
 * <p>Class of {@link CannotWriteCrawler} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This class prepares a {@link RestrictedSearch} instance and
 * fills it with the instance of {@link CanWriteCheck} sealed in the
 * {@link NOTContainer}.</p>
 *
 * <p>This crawler filters out all the files the program can write to;
 * only the files you cannot write to are gonna be in the result of the
 * {@link RestrictedSearch#crawl(File)} method.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-24
 *
 * @see FilesOnlyCrawler
 * @see FoldersOnlyCrawler
 * @see RestrictedSearch
 */
public class CannotWriteCrawler extends RestrictedSearch {


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>This constructor is defining a {@link RestrictedSearch} instance
     * by setting the only restriction as the {@link CanWriteCheck} instance.</p>
     */
    public CannotWriteCrawler() {

        super(new NOTContainer(new CanWriteCheck()));
    }
}
