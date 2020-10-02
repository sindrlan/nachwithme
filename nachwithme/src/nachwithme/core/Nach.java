package nachwithme.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Nach implements ObservableNach {
    private final String address;
    private final String time;
    private final User host;
    private int maxGuestCount;
    private final List<NachObserver> guests;
    private boolean guestListChanged;

    public Nach(User host, String address, String clock) {
        super();
        this.address = address;
        this.host = host;
        this.time = clock;
        this.guests = new ArrayList<>();
        this.guestListChanged = false;
    }

    public Nach(User host) {
        this(host, host.getAddress(), LocalDateTime.now().toString());
    }

    public final String getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return "Nach{" + "address=" + address + ", host=" + host + ", maxGuestCount=" + maxGuestCount + ", guests="
                + guests + '}';
    }

    @Override
    public void addObserver(final NachObserver nacher) {
        if (this.guests.contains(nacher)) {
            return;
        }
        this.guests.add(nacher);
    }

    @Override
    public void deleteObserver(NachObserver nacher) {
        if (!this.guests.contains(nacher)) {
            return;
        }
        this.guests.remove(nacher);
    }

    @Override
    public void deleteObservers() {
        this.guests.clear();
    }

    @Override
    public int countObservers() {
        return this.guests.size();
    }

    @Override
    public void setChanged() {
        this.guestListChanged = true;
    }

    @Override
    public void clearChanged() {
        this.guestListChanged = false;
    }


    @Override
    public boolean hasChanged() {
        return this.guestListChanged;
    }

    @Override
    public void notifyObservers() {
        if (this.hasChanged()) {
            this.guests.forEach(this::notifyObservers);
        }
    }

    @Override
    public void notifyObservers(final NachObserver nacher) {
        nacher.update(this);
    }

    public static void main(String[] args) {
        final String name = "Sigbjørn";
        final String email = "skrt@skrt.com";
        final String address = "Nardobakken 4";
        final int age = 21;
        User me = new User(name, email, address, age);
        Nach nach = new Nach(me);
        System.out.println(me + "\n" +nach);
    }
}
