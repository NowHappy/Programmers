import javax.activation.FileDataSource;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int T, N, ret;
    static int[][] populations = new int[20][20];

    public static void main(String[] args) throws IOException {

        //System.setIn(new FileDataSource("test.txt").getInputStream());
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            ret = Integer.MAX_VALUE;
            N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    populations[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(populations[i][j] + "  ");
                }
                System.out.println();
            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 0; j < N - 1; j++) {
                    dfs(new LocationInfo(j, i), 1);
                }
            }

            System.out.println("#" + tc + " " + ret);

        }

    }


    public static class Point {
        int x;
        int y;

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public Point(int j, int i) {
            this.x = i;
            this.y = j;
        }
    }

    public static class LocationInfo {
        Point startPoint;
        Point leftPoint;
        Point rightPoint;
        Point endPoint;

        public LocationInfo(int j, int i) {
            this.startPoint = new Point(j, i);
            this.leftPoint = new Point();
            this.rightPoint = new Point();
            this.endPoint = new Point();
        }
    }

    public static void dfs(LocationInfo cur, int count) {
        if (count == 4) {
            int[][] testMap = new int[N][N];
            System.out.println("--------- Print Point ---------------");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == cur.startPoint.y && j == cur.startPoint.x) {
                        testMap[i][j] = 5;
                        System.out.print(" " + 0 + " ");
                    } else if (i == cur.leftPoint.y && j == cur.leftPoint.x) {
                        testMap[i][j] = 5;
                        System.out.print(" " + 0 + " ");
                    } else if (i == cur.rightPoint.y && j == cur.rightPoint.x) {
                        testMap[i][j] = 5;
                        System.out.print(" " + 0 + " ");
                    } else if (i == cur.endPoint.y && j == cur.endPoint.x) {
                        testMap[i][j] = 5;
                        System.out.print(" " + 0 + " ");
                    } else {
                        testMap[i][j] = 0;
                        System.out.print(" * ");
                    }
                }
                System.out.println();
            }

            System.out.println("--------- Print Point End---------------");

            int max = 0;
            int min = Integer.MAX_VALUE;
            int lastSum = 0;
            int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
            // 1
            int boundary = cur.startPoint.x;
            boolean boundaryChange = false;
            for (int i = 0; i < cur.leftPoint.y; i++) {
                for (int j = 0; j <= boundary; j++) {
                    if (i < cur.startPoint.y) {
                        testMap[i][j] = 1;
                        first += populations[i][j];
                    } else {
                        if (j == boundary) {
                            continue;
                        }
                        boundaryChange = true;
                        first += populations[i][j];
                        testMap[i][j] = 1;
                    }
                }
                if (boundaryChange) {
                    boundary--;
                    boundaryChange = false;
                }
            }

            lastSum += first;

            if (first > max) {
                max = first;
            }
            if (first < min) {
                min = first;
            }

            // 2
            boundary = cur.startPoint.x + 1;
            boundaryChange = false;
            for (int i = 0; i <= cur.leftPoint.y; i++) {
                for (int j = boundary; j < N; j++) {
                    if (i <= cur.startPoint.y) {
                        testMap[i][j] = 2;
                        second += populations[i][j];
                    } else {
                        if (j == boundary) {
                            continue;
                        }
                        boundaryChange = true;
                        second += populations[i][j];
                        testMap[i][j] = 2;
                    }
                }
                if (boundaryChange) {
                    boundary++;
                    boundaryChange = false;
                }
            }

            lastSum += second;

            if (second > max) {
                max = second;
            }
            if (second < min) {
                min = second;
            }

            // 3
            boundary = cur.leftPoint.x;
            boundaryChange = false;
            for (int i = cur.leftPoint.y; i < N; i++) {
                for (int j = 0; j <= boundary; j++) {
                    if (i < cur.endPoint.y) {
                        boundaryChange = true;
                        if (j == boundary) {
                            continue;
                        }
                        third += populations[i][j];
                        testMap[i][j] = 3;
                    } else {
                        if (j == boundary) {
                            continue;
                        }
                        third += populations[i][j];
                        testMap[i][j] = 3;
                    }
                }
                if (boundaryChange) {
                    boundary++;
                    boundaryChange = false;
                }
            }

            lastSum += third;

            if (third > max) {
                max = third;
            }
            if (third < min) {
                min = third;
            }

            // 4
            boundary = cur.rightPoint.x;
            boundaryChange = false;
            for (int i = cur.rightPoint.y + 1; i < N; i++) {
                for (int j = boundary; j < N; j++) {
                    if (i <= cur.endPoint.y) {
                        boundaryChange = true;
                        fourth += populations[i][j];
                        testMap[i][j] = 4;
                    } else {
                        fourth += populations[i][j];
                        testMap[i][j] = 4;
                    }
                }
                if (boundaryChange) {
                    boundary--;
                    boundaryChange = false;
                }
            }

            lastSum += fourth;

            if (fourth > max) {
                max = fourth;
            }
            if (fourth < min) {
                min = fourth;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(testMap[i][j] + "  ");
                }
                System.out.println();
            }

            // 5
            int totalSum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    totalSum += populations[i][j];
                }
            }

            fifth = totalSum - lastSum;

            if (fifth > max) {
                max = fifth;
            }
            if (fifth < min) {
                min = fifth;
            }

            int tempRet = max - min;
            if (tempRet < ret) {
                ret = tempRet;
            }

        }

        if (count == 1) {
            for (int move = 1; move < N - 1; move++) {
                if (cur.startPoint.x - move >= 0 && cur.startPoint.y + move <= N - 1) {
                    cur.leftPoint.x = cur.startPoint.x - move;
                    cur.leftPoint.y = cur.startPoint.y + move;
                    dfs(cur, count + 1);
                }
            }
        } else if (count == 2) {
            for (int move = 1; move < N - 1; move++) {
                if (cur.startPoint.x + move <= N - 1 && cur.startPoint.y + move <= N - 1) {
                    cur.rightPoint.x = cur.startPoint.x + move;
                    cur.rightPoint.y = cur.startPoint.y + move;
                    dfs(cur, count + 1);
                }
            }
        } else if (count == 3) {
            for (int leftPointMove = 1; leftPointMove < N - 1; leftPointMove++) {
                for (int rightPointMove = 1; rightPointMove < N - 1; rightPointMove++) {
                    if (cur.rightPoint.x - rightPointMove < 0 || cur.rightPoint.y + rightPointMove > N - 1) {
                        return;
                    }
                    if (cur.leftPoint.x + leftPointMove == cur.rightPoint.x - rightPointMove
                            && cur.leftPoint.y + leftPointMove == cur.rightPoint.y + rightPointMove) {
                        cur.endPoint.x = cur.leftPoint.x + leftPointMove;
                        cur.endPoint.y = cur.leftPoint.y + leftPointMove;
                        dfs(cur, count + 1);
                    }
                }
            }

        }

    }


}