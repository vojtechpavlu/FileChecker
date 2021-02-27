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
 * <p>Class of {@link CreatedBeforeCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This class let's you test if the given file was created before
 * the given date or the same. For both of these conditions it returns
 * {@code true}.</p>
 *
 * <p>The marginal date time is an instance of {@link LocalDateTime} and
 * is stored in the abstract ancestor of this class the {@link TimeExaminer}.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-27
 *
 * @see TimeExaminer
 */
public class CreatedBeforeCheck extends TimeExaminer {


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */

    /**
     * <p>This creates an instance by definition of he marginal time
     * as very now - the time of the creation of the instance.</p>
     */
    public CreatedBeforeCheck() {

        super(LocalDateTime.now());
    }


    /**
     * <p>This parametric constructor creates an instance by calling
     * the parent (super class).</p>
     *
     * @param time      to be set as the pivot, the marginal {@link LocalDateTime}
     */
    public CreatedBeforeCheck(LocalDateTime time) {

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

        LocalDateTime created = super.getDateOfCreation(file);

        return !created.isBefore(super.getTime()) || created.equals(super.getTime());
    }
}
