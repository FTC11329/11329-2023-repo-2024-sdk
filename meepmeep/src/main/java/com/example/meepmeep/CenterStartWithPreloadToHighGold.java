package com.example.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.roadrunner.DriveShim;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

public class CenterStartWithPreloadToHighGold implements MeepMeepOpMode {
    public static Pose2d initialPosition = new Pose2d(-63.5, 13.5, 0);//new Pose2d(-63.5, -32.0, 0);//new Pose2d(-63.5, 13.5, 0);

    public static TrajectorySequence generateTrajectorySequence(DriveShim drive) {
        return drive.trajectorySequenceBuilder(initialPosition)
                .splineTo(new Vector2d(75.5+initialPosition.getX(), 0+initialPosition.getY()), initialPosition.getHeading())
                .waitSeconds(0.1)
                .setReversed(true)
                .splineTo(new Vector2d(68+initialPosition.getX(), 3+initialPosition.getY()), Math.toRadians(110) + initialPosition.getHeading())
                .setReversed(false)
                .splineTo(new Vector2d(75.5+initialPosition.getX(), -43.5+initialPosition.getY()), Math.toRadians(-90)+initialPosition.getHeading())
                .splineTo(new Vector2d(75.7 + initialPosition.getX(), -58.5+initialPosition.getY()), Math.toRadians(-90)+initialPosition.getHeading())
                .splineTo(new Vector2d(84.5 + initialPosition.getX() ,-75.5 + initialPosition.getY()), Math.toRadians(-85)+ initialPosition.getHeading())
                .waitSeconds(0.3)
                //.splineTo(new Vector2d(12, -45), Math.toRadians(-90)).setReversed(true)
                .strafeRight(5)
                .waitSeconds(1)
                .lineToLinearHeading(new Pose2d(70.7 + initialPosition.getX(), -43.5+initialPosition.getY(), Math.toRadians(310) + initialPosition.getHeading()))

                //Park Left
                //.splineToLinearHeading(new Pose2d(74 + initialPosition.getX(), 0 + initialPosition.getY(), 0), Math.toRadians(90))
                //Park Center
                //.splineToLinearHeading(new Pose2d(75.5+initialPosition.getX(), -25.5 + initialPosition.getY(), 0), Math.toRadians(90))

                //Park Right
                .splineToLinearHeading(new Pose2d(65.5+initialPosition.getX(), -50.5 + initialPosition.getY(), 0), Math.toRadians(90))
                .build();
    }
}
