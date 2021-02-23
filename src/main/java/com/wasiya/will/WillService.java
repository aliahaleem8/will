package com.wasiya.will;

import org.springframework.stereotype.Service;

@Service
public class WillService {


    public void myWill(Family family){
        if (family.isMale)
            maleWill(family);
        else femaleWill(family);

    }

    private void femaleWill(Family family) {

        if ( family.hasSpouse) {
            if (family.sonsCount == 0 && family.daughtersCount == 0) {
                // husband gets 1/2
                System.out.println("No children, so husband  get higher share of estate, 1/2");

                noKidsCheckParents(family);
                System.out.println("No children, so parents get higher share of estate");

            } else  {
                // husband gets 1/4
                System.out.println("Has children, so husband gets 1/4");
                getChildrenShare(family);
            }
        }
        else // no spouse
        {  System.out.println("No Spouse");
            getChildrenShare(family);
        }

    }

    private void getChildrenShare(Family family) {
        if (family.sonsCount > 0 && family.daughtersCount > 0) {
            System.out.println("Sons get twice daugthers");
            // sons = 2 x daugthers share
            checkParents(family);
        } else if (family.daughtersCount > 1) { //&& family.sonsCount == 0){
            // 2/3 of estate for the daugthers
            System.out.println("Daugthers will share 2/3 of estate");
            checkParents(family);
        } else if (family.daughtersCount ==1) { // && family.sonsCount == 0){
            // 1/2 for only daugther
            System.out.println("Only daughter will get 1/2 estate");
            checkParents(family);
        } else if (family.sonsCount > 1){
            System.out.println("Only sons will get equal portions??");
            checkParents(family);
        }
    }

    private void noKidsCheckParents(Family family) {
        if (family.hasDad) {
            // father = 1/6
            System.out.println("1/6 to father");
        }
        if (family.hasMom) {
            // mother = 1/3 if no siblings
            if (family.brothersCount==0 && family.sistersCount ==0) {
                System.out.println("1/3 to mom");
            }
            else // 1/6 to mom, rest if willed, 1/3 to will and rest amongst siblings
            {
                System.out.println(("1/6th to mom"));

            }
        }
    }

    private void checkParents(Family family) {
        if (family.hasDad) {
            // father = 1/6
            System.out.println("1/6 to father");
        }
        if (family.hasMom) {
            // mother = 1/6
            System.out.println("1/6 to mom");
        }
    }

    private void maleWill(Family family) {

        if ( family.hasSpouse) {
            if (family.sonsCount == 0 && family.daughtersCount == 0) {
                // wife gets 1/4
                System.out.println("No children, so wife get higher share of estate, 1/4");
                if (family.hasMom || family.hasDad) {
                    noKidsCheckParents(family);
                    System.out.println("No children, so parents get higher share of estate");
                }
                else // no parents and no kids
                {
                    checkSiblings(family);
                }

            } else {
                // wife gets 1/8
                System.out.println("Has children, so wife gets 1/8");
                getChildrenShare(family);
            }
        }
        else // no spouse
        {  System.out.println("No Spouse");
            getChildrenShare(family);
        }

    }

    private void checkSiblings(Family family) {

        if (family.brothersCount ==1 && family.sistersCount ==1){
         System.out.println("Each sibling 1/6");
        }
        else if (family.brothersCount+family.sistersCount >2){
            System.out.println("All siblings share 1/3");
        }
    }

}
