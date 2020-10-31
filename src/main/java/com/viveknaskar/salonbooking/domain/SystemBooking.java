package com.viveknaskar.salonbooking.domain;

import lombok.Data;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@NoArgsConstructor
@Getter
@Setter
public class SystemBooking {

    @Id
    private long id;

    private String bookingIdentifier;

    /**
     * Inclusive date.
     */
    private LocalDate bookingFrom;

    /**
     * Exclusive date
     */
    private LocalDate bookingTo;

    @Version
    private long version;

    public SystemBooking(final String bookingIdentifier, final LocalDate bookingFrom, final LocalDate bookingTo) {
        this.bookingIdentifier = bookingIdentifier;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
    }

    public LocalDate getBookingTo() {
        return this.bookingTo.minusDays(1);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("bookingIdentifier", bookingIdentifier)
                .append("bookingFrom", bookingFrom)
                .append("bookingTo", bookingTo)
                .append("version", version)
                .toString();
    }
}
