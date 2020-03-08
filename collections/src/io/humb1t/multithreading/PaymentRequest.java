package io.humb1t.multithreading;

import java.util.Objects;

public class PaymentRequest {
    int userId;
    int prise;

    public PaymentRequest(int userId, int prise) {
        this.userId = userId;
        this.prise = prise;
    }

    public int getUserId() {
        return userId;
    }

    public int getPrise() {
        return prise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRequest that = (PaymentRequest) o;
        return userId == that.userId &&
                prise == that.prise;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, prise);
    }
}
