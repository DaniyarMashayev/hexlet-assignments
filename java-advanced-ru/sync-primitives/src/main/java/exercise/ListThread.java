package exercise;

// BEGIN
class ListThread extends Thread {
    private SafetyList list;

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            list.add(i);
        }
    }
}
// END
