package com.example.jlindahl2742ex2g;

import java.util.ArrayList;
import java.util.Objects;

public class Sensor {
        private int sensorId;
        private int roomId;
        private int sensorTypeId;
        private String description;
        public ArrayList<SensorReading> sensorReadings;

        public Sensor(int sensorId, int roomId, int sensorTypeId, String description) {
            this.sensorId = sensorId;
            this.roomId = roomId;
            this.sensorTypeId = sensorTypeId;
            this.description = description;
        }

        public int getSensorId() {
            return sensorId;
        }

        public void setSensorId(int sensorId) {
            this.sensorId = sensorId;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public int getSensorTypeId() {
            return sensorTypeId;
        }

        public void setSensorTypeId(int sensorTypeId) {
            this.sensorTypeId = sensorTypeId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Sensor)) return false;
            Sensor sensor = (Sensor) o;
            return sensorId == sensor.sensorId &&
                    roomId == sensor.roomId &&
                    sensorTypeId == sensor.sensorTypeId &&
                    Objects.equals(description, sensor.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sensorId, roomId, sensorTypeId, description);
        }

        @Override
        public String toString() {
            return Integer.toString(sensorId) +
                    ", roomId=" + roomId +
                    ", sensorTypeId=" + sensorTypeId +
                    ", " + description;
        }

        public ArrayList<SensorReading> getSensorReadings() {
            return sensorReadings;
        }

        public void setSensorReadings(ArrayList<SensorReading> sensorReadings) {
            this.sensorReadings = sensorReadings;
        }

        //add method that can find the index of the sensor reading with the smallest value
//    public int findMinReadingIndex() {
//        int index = 0;
//        //for loop
//        for (int i = 0; i < sensorReadings.size(); i++) {
//
//        }
//            return 0;
//
//    }
        public int findMinReadingIndex() {
            int minIndex = 0;
            int minValue = 0;
            int i = 0;

            for (SensorReading sensorReading : sensorReadings) {
                if (i == 0 || sensorReading.getValue() < minValue) {
                    minValue = (int) sensorReading.getValue();
                    minIndex = i;
                }

                i++;
            }

            return minIndex;

        }

        public int findMaxReadingIndex() {
            int maxValue = (int) sensorReadings.get(0).getValue();
            int maxIndex = 0;
            int i = 0;

            for (SensorReading sensorReading : sensorReadings) {
                if (sensorReading.getValue() > maxValue) {
                    maxValue = (int) sensorReading.getValue();
                    maxIndex = i;
                }

                i++;
            }

            return maxIndex;
        }

        public int findMinReadingIndex1(int startIndex, int endIndex) {
            int minValue = (int) sensorReadings.get(startIndex).getValue();
            int minIndex = startIndex;
            int i = 0;

            for (SensorReading sensorReading : sensorReadings) {
                if (i >= startIndex && i<= endIndex && sensorReading.getValue() < minValue) {
                    minValue = (int) sensorReading.getValue();
                    minIndex = i;
                }

                i++;
            }
            if (startIndex <= 0 && endIndex <= sensorReadings.size() - 1) {
                throw new IndexOutOfBoundsException();
            }


            return minIndex;
        }



        public int findMaxReadingIndex1(int startIndex, int endIndex) {
            int maxValue = (int) sensorReadings.get(startIndex).getValue();
            int maxIndex = startIndex;
            int i = 0;

            for (SensorReading sensorReading : sensorReadings) {
                if (i >= startIndex && i<= endIndex && sensorReading.getValue() > maxValue) {
                    maxValue = (int) sensorReading.getValue();
                    maxIndex = i;
                }

                i++;
            }
            if (startIndex <= 0 && endIndex <= sensorReadings.size() - 1) {
                throw new IndexOutOfBoundsException();
            }

            return maxIndex;
        }

        public int findNextCycleMax(int startIndex) {
            SensorReading rMax = this.sensorReadings.get(startIndex);
            int i = startIndex + 1;

            for (; i < this.sensorReadings.size() - 1; i++) {
                if (rMax.getValue() < this.sensorReadings.get(i).getValue()) {
                    rMax = this.sensorReadings.get(i);
                }
                else
                    break;
            }
            return i - 1;
        }
        public int findNextCycleMin(int startIndex) {
            SensorReading rMax = this.sensorReadings.get(startIndex);
            int i = startIndex + 1;

            for (; i < this.sensorReadings.size() - 1; i++) {
                if (rMax.getValue() > this.sensorReadings.get(i).getValue()) {
                    rMax = this.sensorReadings.get(i);
                }
                else
                    break;
            }
            return i - 1;
        }

        public SensorReading getSensorReading(int index) {
            return this.sensorReadings.get(index);
        }
    }

