package org.firstinspires.ftc.teamcode.auto.roadrunnerautos;




import androidx.annotation.NonNull;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryAccelerationConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.roadrunner.RoadRunnerAutoBase;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequenceBuilder;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Brace;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Slides;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

import java.lang.reflect.InvocationTargetException;

@Autonomous(name = "Left Center Auto| GoldCone HOLD", group = "Competition")
public class LeftCenterGoldConeHold extends RoadRunnerAutoBase {
    Arm arm;
    Claw claw;
    Slides slides;
    Brace brace;

    @Override
    public void ResolveSubsystems() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        arm = (Arm) Container.resolve(Arm.class);
        claw = (Claw) Container.resolve(Claw.class);
        slides = (Slides) Container.resolve(Slides.class);
        brace = (Brace) Container.resolve(Brace.class);
    }

    @Override
    public void build(TrajectorySequenceBuilder trajectorySequenceBuilder) {
        claw.grab();
        trajectorySequenceBuilder
                //Setup--
                .addDisplacementMarker(() -> {
                    claw.grab(); //Grabs preload
                    brace.unbrace();
                    claw.setPresetBool(true);
                    //claw.setPos(RobotConfig.Presets.WristPickup);
                    arm.toPosition(RobotConfig.Presets.Arm1Pickup);
                })
//                .addTemporalMarker(0.75, () ->{
//                    //arm.toPosition(RobotConfig.Presets.Arm1Pickup+150);
//                })
                .addTemporalMarker(2, () ->{
                    //arm.toPosition(RobotConfig.Presets.Arm1Pickup  );
                    //claw.setPos(RobotConfig.Wrist.startingPosition);
                    //claw.grab();
                })
                .addTemporalMarker(2, () ->{
                    //arm.toPosition(RobotConfig.Presets.Arm1Pickup  );
                    //claw.setPos(RobotConfig.Wrist.startingPosition);
                    claw.setPos(RobotConfig.Wrist.startingPosition);
                    //claw.grab();
                })

                .setConstraints(new TrajectoryVelocityConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 60;
                    }
                }, new TrajectoryAccelerationConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 54;
                    }
                })
                .splineToLinearHeading(new Pose2d(76 , 8, Math.toRadians(90)), 0)
                // .splineTo(new Vector2d(42, -7.5), 0)
                // .splineTo(new Vector2d(42, -4), 0)
                .setConstraints(new TrajectoryVelocityConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 60;
                    }
                }, new TrajectoryAccelerationConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 54;
                    }
                })
                //.splineTo(new Vector2d(79, -50), Math.toRadians(-90))
                .setConstraints(new TrajectoryVelocityConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 60;
                    }
                }, new TrajectoryAccelerationConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 55;
                    }
                })
                .addTemporalMarkerOffset(0.5, () -> {
                    claw.setPos(RobotConfig.Presets.WristPickup);
                    claw.ungrab();

                })

                .splineToLinearHeading(new Pose2d(84 , 76, Math.toRadians(85 )), Math.toRadians(90))
                //.splineTo(new Vector2d(83.0 , -40.5), Math.toRadians(-90))
                //.waitSeconds(10)
                //.splineTo(new Vector2d(83.0  ,-47.5 ), Math.toRadians(-90))
                //.splineTo(new Vector2d(95.5  ,-60.0 ), Math.toRadians(-90))//was 100.5 -57.5
                //.waitSeconds(5)
                //.waitSeconds(20)


                .addTemporalMarkerOffset(0, () -> {
                    claw.grab();

                })
                .addTemporalMarkerOffset(   0.25, () -> {
                    slides.setTargetPosition(RobotConfig.Presets.SlidesPickupTop);

                })
                //.waitSeconds(0.75)
                .lineTo(new Vector2d(71, 55))

                //.waitSeconds(3);
//                .addTemporalMarkerOffset(3, () -> {
//                    slides.setTargetPosition(RobotConfig.Presets.SlidesPickup);
//                    arm.toPosition(RobotConfig.Presets.Arm1Pickup);
//                    brace.unbrace();
//                });
                .setConstraints(new TrajectoryVelocityConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 60;
                    }
                }, new TrajectoryAccelerationConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 60;
                    }
                });


    }


    @Override
    public void buildParkLeft(TrajectorySequenceBuilder trajectorySequenceBuilder) {
        trajectorySequenceBuilder
                .addTemporalMarkerOffset(0, () -> {
                    claw.setPos(RobotConfig.Wrist.startingPosition);

                    arm.toPosition(RobotConfig.Presets.Arm1Pickup);
                    brace.unbrace();
                })

                .splineToLinearHeading(new Pose2d(78, 50 , 0), Math.toRadians(-90));
    }
    @Override
    public void buildParkCenter(TrajectorySequenceBuilder trajectorySequenceBuilder) {
        trajectorySequenceBuilder
                .addTemporalMarkerOffset(0, () -> {
                    claw.setPos(RobotConfig.Wrist.startingPosition);

                    arm.toPosition(RobotConfig.Presets.Arm1Pickup);
                    brace.unbrace();
                })
                .splineToLinearHeading(new Pose2d(75.5, 25.5, 0), Math.toRadians(-90));
    }
    @Override
    public void buildParkRight(TrajectorySequenceBuilder trajectorySequenceBuilder) {
        trajectorySequenceBuilder
                .addTemporalMarkerOffset(0, () -> {
                    claw.setPos(RobotConfig.Wrist.startingPosition);

                    arm.toPosition(RobotConfig.Presets.Arm1Pickup);
                    brace.unbrace();
                })
                .splineToLinearHeading(new Pose2d(72, 3, 0), Math.toRadians(-90));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Red;
    }
}