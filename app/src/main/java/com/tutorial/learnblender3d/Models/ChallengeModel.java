package com.tutorial.learnblender3d.Models;

import com.tutorial.learnblender3d.Adapters.CustomChallengeAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class ChallengeModel implements Serializable {

    public CustomChallengeModel customChallengeModel;
    public int[] steps;
    public String[] stepsDescriptions;
}
