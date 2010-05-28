package barenko.util.log.appender;

import java.io.File;

public interface FileAppender extends Appender {
    File getFile();

    boolean isAutoOverride();
}
