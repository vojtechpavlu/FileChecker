package io.github.vojtechpavlu.fileChecker.core.date;


import java.io.File;
import java.io.IOException;
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
 * <p>Class of {@link LastModifiedBeforeCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This instance can check the given file if it's last modification
 * happen before the given marginal time.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-27
 */
public class LastModifiedBeforeCheck extends TimeExaminer {


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>This creates an instance by definition of he marginal time
     * as very now - the time of the last modification of the instance.</p>
     */
    public LastModifiedBeforeCheck() {

        super(LocalDateTime.now());
    }


    /**
     * <p>This parametric constructor creates an instance by calling
     * the parent (super class).</p>
     *
     * @param time to be set as the pivot, the marginal {@link LocalDateTime}
     */
    public LastModifiedBeforeCheck(LocalDateTime time) {

        super(time);
    }


    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */

    /**
     * <p>This method is responsible for checking, if the given {@link File}
     * corresponds the rules defined by this class.</p>
     *
     * @param file Path to the {@link File} to be checked.
     *
     * @return {@code true} when the given file passes all
     * the subtests defined by this class. Otherwise
     * it returns {@code false}
     *
     * @throws IOException When some error occurs. Usually it's because the
     *                     file does not exist or is not reachable.
     */
    @Override
    public boolean check(File file) throws IOException {

        LocalDateTime modified = super.getDateOfLastModification(file);

        return modified.isBefore(super.getTime()) || modified.isEqual(super.getTime());
    }
}
