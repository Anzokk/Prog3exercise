package org.prog3.lab.week6.es1.es1_consegna;

class Counter {
    private int val;
    private Filter filter;

    public Counter(Filter f) {
        val = 0;
        filter = f;
    }

    public void start() {
        for (int i = 0; i < 50; i++) {
            val++;
            if (val % 5 == 0) {
                filter.filter(val);
            }
        }
    }
}