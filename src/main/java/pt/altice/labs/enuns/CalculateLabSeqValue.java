package pt.altice.labs.enuns;

public enum CalculateLabSeqValue {

    ZERO_ONE {
        @Override
        public int calculateValue(int n) {
            switch (n) {
                case 0:
                case 2:
                    return 0;
                case 1:
                case 3:
                    return 1;
                default: return calculateRecursiveValue(n);
            }
        }
    },
    RECURSIVE {
        @Override
        public int calculateValue(int n) {
            if (n >= 4) {
                return ZERO_ONE.calculateValue(n - 4) +
                        ZERO_ONE.calculateValue(n - 3);
            }
            return ZERO_ONE.calculateValue(n);
        }
    };

    private static int calculateRecursiveValue(int n) {
        return ZERO_ONE.calculateValue(n - 4) +
                ZERO_ONE.calculateValue(n - 3);
    }

    public abstract int calculateValue(int n);

}
