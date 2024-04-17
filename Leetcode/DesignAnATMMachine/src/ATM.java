class ATM {
    int denominations[];
    int availableDenominations[];
    public ATM() {
        availableDenominations = new int[5];
        denominations = new int[]{20,50,100,200,500};
    }

    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < 5; i++){
            availableDenominations[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int dispensedDenominations[] = new int[5];
        for(int i = 4; i >= 0 && amount > 0; i--){
            if(availableDenominations[i] > 0 && amount >= denominations[i]){
                int denominationCount = amount / denominations[i];

                if(availableDenominations[i] < denominationCount){
                    denominationCount = availableDenominations[i];
                }

                dispensedDenominations[i] = denominationCount;
                availableDenominations[i] -= denominationCount;
                amount = amount - (denominations[i] * denominationCount);

            }
        }

        if(amount == 0){
            return dispensedDenominations;
        } else {
            for(int i = 0; i < 5; i++){
                availableDenominations[i] += dispensedDenominations[i];
            }
            return new int[]{-1};
        }
    }
}