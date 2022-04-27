package util;

public class CommStatus {
    public static final boolean SUCCESS = true;

    // On command "abnormal" execution,
    // true is returned to avoid sending
    // its "usage" entry (see plugin.yml).
    public static final boolean MASK = true;
}
