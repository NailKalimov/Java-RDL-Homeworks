package Builder;

import java.io.IOException;

public interface IBuilder {
    void reset();

    void setRecipients() throws IOException;

    void setSubject() throws IOException;

    void setText() throws IOException;
}
