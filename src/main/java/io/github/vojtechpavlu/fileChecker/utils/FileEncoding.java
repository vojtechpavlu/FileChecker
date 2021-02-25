package io.github.vojtechpavlu.fileChecker.utils;


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
 * <p>Enumeration of {@link FileEncoding} is an abstract container of these
 * related types.</p>
 *
 * <p></p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 */
public enum FileEncoding {

    ANSI ("Cp1252"),
    CESU_8 ("CESU8"),
    IBM00858 ("Cp858"),
    IBM437 ("Cp437"),
    IBM775 ("Cp775"),
    IBM850 ("Cp850"),
    IBM852 ("Cp852"),
    IBM855 ("Cp855"),
    IBM857 ("Cp857"),
    IBM862 ("Cp862"),
    IBM866 ("Cp866"),
    ISO_8859_1 ("ISO8859_1"),
    ISO_8859_2 ("ISO8859_2"),
    ISO_8859_4 ("ISO8859_4"),
    ISO_8859_5 ("ISO8859_5"),
    ISO_8859_7 ("ISO8859_7"),
    ISO_8859_9 ("ISO8859_9"),
    ISO_8859_13 ("ISO8859_13"),
    ISO_8859_15 ("ISO8859_15"),
    KOI8_R ("KOI8_R"),
    KOI8_U ("KOI8_U"),
    US_ASCII ("ASCII"),
    UTF_8 ("UTF8"),
    UTF_16 ("UTF-16"),
    UTF_16BE ("UnicodeBigUnmarked"),
    UTF_16LE ("UnicodeLittleUnmarked"),
    UTF_32 ("UTF_32"),
    UTF_32BE ("UTF_32BE"),
    UTF_32LE ("UTF_32LE"),
    x_UTF_32BE_BOM ("UTF_32BE_BOM"),
    x_UTF_32LE_BOM ("UTF_32LE_BOM"),
    windows_1250 ("Cp1250"),
    windows_1251 ("Cp1251"),
    windows_1252 ("Cp1252"),
    windows_1253 ("Cp1253"),
    windows_1254 ("Cp1254"),
    windows_1257 ("Cp1257"),
    x_IBM737 ("Cp737"),
    x_IBM874 ("Cp874"),
    x_UTF_16LE_BOM ("UnicodeLittle");


    private String encoding;

    FileEncoding(String encoding) {

        this.encoding = encoding;
    }


    public String getEncoding() {

        return encoding;
    }

    public static FileEncoding search(String encoding) {

        for (FileEncoding fe : FileEncoding.values()) {

            if(fe.getEncoding().equals(encoding)) {

                return fe;
            }
        }

        return null;
    }
}
