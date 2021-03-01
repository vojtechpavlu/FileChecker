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
 * <p>Compilation of supported file encodings the Java can work with.
 * Client can just pick an encoding by it's name and use it for reading
 * files.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 *
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html">Encodings</a>
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
    x_UTF_16LE_BOM ("UnicodeLittle"),
    BIG5 ("Big5"),
    BIG5_HKSCS ("Big5_HKSCS"),
    EUC_JP ("EUC_JP"),
    EUC_KR ("EUC_KR"),
    GB18030 ("GB18030"),
    GB2312 ("EUC_CN"),
    GBK ("GBK"),
    IBM_THAI ("Cp838"),
    IBM01140 ("Cp1140"),
    IBM01141 ("Cp1141"),
    IBM01142 ("Cp1142"),
    IBM01143 ("Cp1143"),
    IBM01144 ("Cp1144"),
    IBM01145 ("Cp1145"),
    IBM01146 ("Cp1146"),
    IBM01147 ("Cp1147"),
    IBM01148 ("Cp1148"),
    IBM01149 ("Cp1149"),
    IBM037 ("Cp037"),
    IBM1026 ("Cp1026"),
    IBM1047 ("Cp1047"),
    IBM273 ("Cp273"),
    IBM277 ("Cp277"),
    IBM278 ("Cp278"),
    IBM280 ("Cp280"),
    IBM284 ("Cp284"),
    IBM285 ("Cp285"),
    IBM290 ("Cp290"),
    IBM297 ("Cp297"),
    IBM420 ("Cp420"),
    IBM424 ("Cp424"),
    IBM500 ("Cp500"),
    IBM860 ("Cp860"),
    IBM861 ("Cp861"),
    IBM863 ("Cp863"),
    IBM864 ("Cp864"),
    IBM865 ("Cp865"),
    IBM868 ("Cp868"),
    IBM869 ("Cp869"),
    IBM870 ("Cp870"),
    IBM871 ("Cp871"),
    IBM918 ("Cp918"),
    ISO_2022_CN ("ISO2022CN"),
    ISO_2022_JP ("ISO2022JP"),
    ISO_2022_JP_2 ("ISO2022JP2"),
    ISO_2022_KR ("ISO2022KR"),
    ISO_8859_3 ("ISO8859_3"),
    ISO_8859_6 ("ISO8859_6"),
    ISO_8859_8 ("ISO8859_8"),
    JIS_X0201 ("JIS_X0201"),
    JIS_X0212_1990 ("JIS_X0212-1990"),
    SHIFT_JIS ("SJIS"),
    TIS_620 ("TIS620"),
    WINDOWS_1255 ("Cp1255"),
    WINDOWS_1256 ("Cp1256"),
    WINDOWS_1258 ("Cp1258"),
    WINDOWS_31J ("MS932"),
    X_BIG5_SOLARIS ("Big5_Solaris"),
    X_EUC_JP_LINUX ("EUC_JP_LINUX"),
    X_EUC_TW ("EUC_TW"),
    X_EUCJP_OPEN ("EUC_JP_Solaris"),
    X_IBM1006 ("Cp1006"),
    X_IBM1025 ("Cp1025"),
    X_IBM1046 ("Cp1046"),
    X_IBM1097 ("Cp1097"),
    X_IBM1098 ("Cp1098"),
    X_IBM1112 ("Cp1112"),
    X_IBM1122 ("Cp1122"),
    X_IBM1123 ("Cp1123"),
    X_IBM1124 ("Cp1124"),
    X_IBM1166 ("Cp1166"),
    X_IBM1364 ("Cp1364"),
    X_IBM1381 ("Cp1381"),
    X_IBM1383 ("Cp1383"),
    X_IBM300 ("Cp300"),
    X_IBM33722 ("Cp33722"),
    X_IBM833 ("Cp833"),
    X_IBM834 ("Cp834"),
    X_IBM856 ("Cp856"),
    X_IBM875 ("Cp875"),
    X_IBM921 ("Cp921"),
    X_IBM922 ("Cp922"),
    X_IBM930 ("Cp930"),
    X_IBM933 ("Cp933"),
    X_IBM935 ("Cp935"),
    X_IBM937 ("Cp937"),
    X_IBM939 ("Cp939"),
    X_IBM942 ("Cp942"),
    X_IBM942C ("Cp942C"),
    X_IBM943 ("Cp943"),
    X_IBM943C ("Cp943C"),
    X_IBM948 ("Cp948"),
    X_IBM949 ("Cp949"),
    X_IBM949C ("Cp949C"),
    X_IBM950 ("Cp950"),
    X_IBM964 ("Cp964"),
    X_IBM970 ("Cp970"),
    X_ISCII91 ("ISCII91"),
    X_ISO2022_CN_CNS ("ISO2022_CN_CNS"),
    X_ISO2022_CN_GB ("ISO2022_CN_GB"),
    X_ISO_8859_11 ("x-iso-8859-11"),
    X_JIS0208 ("x-JIS0208"),
    X_JISAUTODETECT ("JISAutoDetect"),
    X_JOHAB ("x-Johab"),
    X_MACARABIC ("MacArabic"),
    X_MACCENTRALEUROPE ("MacCentralEurope"),
    X_MACCROATIAN ("MacCroatian"),
    X_MACCYRILLIC ("MacCyrillic"),
    X_MACDINGBAT ("MacDingbat"),
    X_MACGREEK ("MacGreek"),
    X_MACHEBREW ("MacHebrew"),
    X_MACICELAND ("MacIceland"),
    X_MACROMAN ("MacRoman"),
    X_MACROMANIA ("MacRomania"),
    X_MACSYMBOL ("MacSymbol"),
    X_MACTHAI ("MacThai"),
    X_MACTURKISH ("MacTurkish"),
    X_MACUKRAINE ("MacUkraine"),
    X_MS932_0213 ("x-MS950-HKSCS MS950_HKSCS"),
    X_MS950_HKSCS ("MS950_HKSCS"),
    X_MS950_HKSCS_XP ("x-mswin-936 MS936"),
    X_MSWIN_936 ("MS936"),
    X_PCK ("PCK"),
    X_SJIS_0213 ("x-SJIS_0213"),
    X_WINDOWS_50220 ("Cp50220"),
    X_WINDOWS_50221 ("Cp50221"),
    X_WINDOWS_874 ("MS874"),
    X_WINDOWS_949 ("MS949"),
    X_WINDOWS_950 ("MS950"),
    X_WINDOWS_ISO2022JP ("x-windows-iso2022jp");


    /** Stores the encoding text equivalent */
    private String encoding;


    /**
     * <p>Constructor of the encoding. It's defined by the {@link String} name
     * equivalent of the encoding.</p>
     *
     * @param encoding  String-formed encoding charset name
     */
    FileEncoding(String encoding) {

        this.encoding = encoding;
    }


    /**
     * <p>Returns the name charset name of the encoding.</p>
     *
     * @return  Name of the charset used to identify the correct encoding
     */
    public String getEncoding() {

        return encoding;
    }


    /**
     * <p>Searches the {@link FileEncoding} instance represented by the
     * String form used inside Java environment.</p>
     *
     * @param encoding      String-formed code representing an encoding
     *                      in the Java environment
     *
     * @return              When there really is such an encoding, it returns
     *                      it. It goes through all the defined in this enum
     *                      class. When it does not find such an instance, it
     *                      returns {@code null}.
     *
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html">Encodings</a>
     */
    public static FileEncoding search(String encoding) {

        for (FileEncoding fe : FileEncoding.values()) {

            if(fe.getEncoding().equals(encoding)) {

                return fe;
            }
        }

        return null;
    }
}
