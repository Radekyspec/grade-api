package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

import java.util.Arrays;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team myTeam = gradeDB.getMyTeam();
        String[] utorids = myTeam.getMembers();
        int[] grades = new int[utorids.length];
        for (int i = 0; i < utorids.length; i++) {
            grades[i] = gradeDB.getGrade(utorids[i], course).getGrade();
        }
        return (float) Arrays.stream(grades).sum() / utorids.length;
    }
}
