package ru.pij.dimon.task23;


public class CashMachine {
    private int amountBanknote20 = 0;
    private int amountBanknote50 = 0;
    private int amountBanknote100 = 0;
    private int[]arrayResult = new int[3];
    private Banknote[] containerBanknote20;
    private Banknote[] containerBanknote50;
    private Banknote[] containerBanknote100;

    public CashMachine(int amountBanknote20, int amountBanknote50, int amountBanknote100) {
        containerBanknote20 = new Banknote[amountBanknote20];
        containerBanknote50 = new Banknote[amountBanknote50];
        containerBanknote100 = new Banknote[amountBanknote100];
    }

    public int[] getArrayResult() {
        return arrayResult;
    }

    public int getAmountBanknote20() {
        return amountBanknote20;
    }

    public int getAmountBanknote50() {
        return amountBanknote50;
    }

    public int getAmountBanknote100() {
        return amountBanknote100;
    }

    public boolean addBanknote20(Banknote[] arrayBanknote) {
        if((amountBanknote20+arrayBanknote.length)>containerBanknote20.length){
            return false;
        }
        addBanknote(arrayBanknote,containerBanknote20);
        amountBanknote20 +=arrayBanknote.length;
        return true;
    }

    public boolean addBanknote50(Banknote[] arrayBanknote) {
        if((amountBanknote50+arrayBanknote.length)>containerBanknote50.length){
            return false;
        }
        addBanknote(arrayBanknote,containerBanknote50);
        amountBanknote50 +=arrayBanknote.length;
        return true;
    }

    public boolean addBanknote100(Banknote[] arrayBanknote) {
        if((amountBanknote100+arrayBanknote.length)>containerBanknote100.length){
            return false;
        }
        addBanknote(arrayBanknote,containerBanknote100);
        amountBanknote100 +=arrayBanknote.length;
        return true;
    }

    public boolean getMoney (int sum){
        if(sum>(amountBanknote20*20+amountBanknote50*50+amountBanknote100*100)){
            return false;
        }
        switch (sum){
            case 10:
            case 30:
                return false;
            case 20:{
                if (amountBanknote20>=1) {
                    arrayResult[2] = 1;
                    amountBanknote20 -=1;
                    return true;
                }
                return false;
            }
            case 40:{
                if(amountBanknote20>=2){
                    arrayResult[2] = 2;
                    amountBanknote20 -=2;
                    return true;
                }
                return false;
            }
            case 50:{
                if(amountBanknote50>=1){
                    arrayResult[1] = 1;
                    amountBanknote50 -=1;
                    return true;
                }
                return false;
            }
            case 60:{
                if(amountBanknote20>=3){
                    arrayResult[2] = 3;
                    amountBanknote20 -=3;
                    return true;
                }
                return false;
            }
            case 70:{
                if(amountBanknote20>=1 && amountBanknote50>=1){
                    arrayResult[1] = 1;
                    arrayResult[2] = 1;
                    amountBanknote50 -=1;
                    amountBanknote20 -=1;
                    return true;
                }
                return false;
            }
            case 80:{
                if(amountBanknote20>=4){
                    arrayResult[2] = 4;
                    amountBanknote20 -=4;
                    return true;
                }
                return false;
            }
            case 90:{
                if(amountBanknote20>=2 && amountBanknote50>=1){
                    arrayResult[1] = 1;
                    arrayResult[2] = 2;
                    amountBanknote50 -=1;
                    amountBanknote20 -=2;
                    return true;
                }
                return false;
            }
            case 110:{
                if(amountBanknote20>=3 && amountBanknote50>=1){
                    arrayResult[1] = 1;
                    arrayResult[2] = 3;
                    amountBanknote50 -=1;
                    amountBanknote20 -=3;
                    return true;
                }
               return false;
            }
            case 130:{
                if(amountBanknote20>=4 && amountBanknote50>=1){
                    arrayResult[1] = 1;
                    arrayResult[2] = 4;
                    amountBanknote50 -=1;
                    amountBanknote20 -=4;
                    return true;
                }
                return false;
            }
        }
        if(sum % 100 == 0){
            if (verify(sum,arrayResult)){
                return true;
            }
            return false;
        }
        if (sum % 50 == 0) {
            if(amountBanknote50>0){
                amountBanknote50 = amountBanknote50-((sum%100)/50);
                if(verify((sum-(sum%100)),arrayResult)) {
                    arrayResult[1] = arrayResult[1]+((sum%100)/50);
                    return true;
                } else {
                    amountBanknote50 = amountBanknote50+((sum%100)/50);
                }
            }
           return false;
        }
        if (sum % 20 == 0){
            if(amountBanknote20 < 1){
                return false;
            } else if(amountBanknote20 < 2 && sum%100>20){
                return false;
            }else if (amountBanknote20 < 3 && sum%100>40){
                return false;
            }else if(amountBanknote20 < 4 && sum%100>60){
                return false;
            }
            amountBanknote20 = amountBanknote20-((sum%100)/20);
            if(verify((sum-(sum%100)),arrayResult)){
                arrayResult[2] = arrayResult[2]+((sum%100)/20);
                return true;
            } else {amountBanknote20 = amountBanknote20+((sum%100)/20);
            return false;
            }
        }
        if (sum % 50 == 20){
            if(amountBanknote50<1 || amountBanknote20<1){
                return false;
            }
            amountBanknote50 = amountBanknote50-1;
            amountBanknote20 = amountBanknote20-1;
            if(verify((sum-(sum%100)),arrayResult)){
                arrayResult[1] = arrayResult[1]+1;
                arrayResult[2] = arrayResult[2]+1;
                return true;
            }else{
                amountBanknote50 = amountBanknote50+1;
                amountBanknote20 = amountBanknote20+1;
                return false;
            }
        }
        if (sum % 50 == 40){
            if(amountBanknote50<1 || amountBanknote20<2){
                return false;
            }
            amountBanknote50 = amountBanknote50-1;
            amountBanknote20 = amountBanknote20-2;
            if(verify((sum-(sum%100)),arrayResult)){
                arrayResult[1] = arrayResult[1]+1;
                arrayResult[2] = arrayResult[2]+2;
                return true;
            }else {
                amountBanknote50 = amountBanknote50+1;
                amountBanknote20 = amountBanknote20+2;
                return false;
            }
        }
        if (sum % 100 == 10){
            if(amountBanknote50<1 || amountBanknote20<3){
                return false;
            }
            amountBanknote50 = amountBanknote50-1;
            amountBanknote20 = amountBanknote20-3;
            if(verify((sum-110),arrayResult)){
                arrayResult[1] = arrayResult[1]+1;
                arrayResult[2] = arrayResult[2]+3;
                return true;
            } else {
                amountBanknote50 = amountBanknote50+1;
                amountBanknote20 = amountBanknote20+3;
                return false;
            }
        }
        if (sum % 100 == 30){
            if(amountBanknote50<1 || amountBanknote20<4){
                return false;
            }
            amountBanknote50 = amountBanknote50-1;
            amountBanknote50 = amountBanknote50-4;
            if(verify((sum-130),arrayResult)){
                arrayResult[1] = arrayResult[1]+1;
                arrayResult[2] = arrayResult[2]+4;
                return true;
            }else {
                amountBanknote50 = amountBanknote50+1;
                amountBanknote50 = amountBanknote50+4;
                return false;
            }
        }
        return false;
    }

    private boolean verify(int sum, int [] arrayResult) {
        int amount100;
        int amount50;
        int amount20;
        amount100 = (sum / 100) / 2;
        amount50 = ((sum/100)-amount100)+(((sum/100)-amount100)%2);
        amount20 = (sum - (amount50 * 50 + amount100 * 100))/20;

        if (amount100<=amountBanknote100 && amount50<=amountBanknote50 && amount20<=amountBanknote20) {
            arrayResult[0] = amount100;
            arrayResult[1] = amount50;
            arrayResult[2] = amount20;
            amountBanknote20 = amountBanknote20-amount20;
            amountBanknote50 = amountBanknote50-amount50;
            amountBanknote100 = amountBanknote100-amount100;
        }else if(amount100>amountBanknote100){
            int diff;
            diff = amount100-amountBanknote100;
            if(amount50+2*diff<=amountBanknote50){
                if(amount20<=amountBanknote20){
                    arrayResult[0] = amountBanknote100;
                    arrayResult[1] = (amount50+2*diff);
                    arrayResult[2] = amount20;
                    amountBanknote20 = amountBanknote20-amount20;
                    amountBanknote50 = amountBanknote50-(amount50+2*diff);
                    amountBanknote100 = 0;
                } else {
                    int diff2;
                    int s=amountBanknote20-(amountBanknote20%5);
                    diff2 = (amount20-s)-((amount20-s)%5);
                    if ((amount50+(int) (diff2/2.5))<=amountBanknote50){
                        arrayResult[0] = amountBanknote100;
                        arrayResult[1] = (amount50+(2*diff)+(int)(diff2/2.5));
                        arrayResult[2] = s;
                        amountBanknote20 = amountBanknote20-s;
                        amountBanknote50 = amountBanknote50-(amount50+(2*diff)+(int)(diff2/2.5));
                        amountBanknote100 = 0;
                    }else{
                        return false;
                    }
                }
            }else {
                int diff1;
                diff1 = ((amount50+2*diff)-amountBanknote50)+(((amount50+2*diff)-amountBanknote50)%2);
                if (amount20+(int)(2.5*diff1)<=amountBanknote20){
                    arrayResult[0] = amountBanknote100;
                    arrayResult[1] = ((amount50+2*diff)-diff1);
                    arrayResult[2] = (amount20+(int)(2.5*diff1));
                    amountBanknote100 = 0;
                    amountBanknote50 = amountBanknote50-((amount50+2*diff)-diff1);
                    amountBanknote20 = amountBanknote20-(amount20+(int)(2.5*diff1));
                } else {
                    return false;
                }
            }
        }else if (amount50>amountBanknote50){
            int diff;
            diff = (amount50-amountBanknote50)+((amount50-amountBanknote50)%2);
            if((amount100+(diff/2))<=amountBanknote100){
                if(amount20<=amountBanknote20){
                    arrayResult[0] = (amount100+(diff/2));
                    arrayResult[1] = (amount50-diff);
                    arrayResult[2] = amount20;
                    amountBanknote20 = amountBanknote20-amount20;
                    amountBanknote100 = amountBanknote100-(amount100+(diff/2));
                    amountBanknote50 = amountBanknote50-(amount50-diff);
                } else {
                    int diff2;
                    int s=amountBanknote20-(amountBanknote20%5);
                    diff2 = (amount20-s)-((amount20-s)%5);
                    if((amount100+(diff2/5))<=amountBanknote100){
                        arrayResult[0] = (amount100+(diff2/5)+(diff/2));
                        arrayResult[1] = (amount50-diff);
                        arrayResult[2] = s;
                        amountBanknote20 = amountBanknote20-s;
                        amountBanknote100 = amountBanknote100-(amount100+(diff2/5)+(diff/2));
                        amountBanknote50 = amountBanknote50-(amount50-diff);
                    } else {
                        return false;
                    }
                }
            }else {
                int diff1;
                diff1 = (amount100+(diff/2))-amountBanknote100;
                if ((amount20+diff1*5)<=amountBanknote20){
                    arrayResult[0] = amountBanknote100;
                    arrayResult[1] = (amount50-diff);
                    arrayResult[2] = (amount20+diff1*5);
                    amountBanknote20 = amountBanknote20-(amount20+diff1*5);
                    amountBanknote50 = amountBanknote50-(amount50-diff);
                    amountBanknote100 = 0;
                }else{
                    return false;
                }
            }
        }else if(amount20>amountBanknote20){
            int diff;
            int s=amountBanknote20-(amountBanknote20%5);
            diff = (amount20-s)-((amount20-s)%5);
            if((amount100+(diff/5))<=amountBanknote100){
                arrayResult[0] = (amount100+(diff/5));
                arrayResult[1] = amount50;
                arrayResult[2] = s;
                amountBanknote20 = amountBanknote20-s;
                amountBanknote100 = amountBanknote100-(amount100+(diff/5));
                amountBanknote50 = amountBanknote50-amount50;
            }else {
                int diff1;
                diff1 = (amount100+(diff/5))-amountBanknote100;
                if ((amount50+diff1*2)<=amountBanknote50){
                    arrayResult[0] = amountBanknote100;
                    arrayResult[1] = (amount50+diff1*2);
                    arrayResult[2] = s;
                    amountBanknote20 = amountBanknote20-s;
                    amountBanknote50 = amountBanknote50-(amount50+diff1*2);
                    amountBanknote100 = 0;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    private void addBanknote(Banknote arrayBanknote[], Banknote []containerBanknote) {
        int count = 0;
        for (int i = 0; i < containerBanknote.length; i++) {
            if(containerBanknote[i] == null && count < arrayBanknote.length){
                containerBanknote[i] = arrayBanknote[count++];
            }
        }

    }




}
