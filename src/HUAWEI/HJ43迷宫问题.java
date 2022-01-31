package HUAWEI;

import java.util.*;

public class HJ43迷宫问题 {
    static final int U = 1;
    static final int D = 2;
    static final int L = 3;
    static final int R = 4;
    static final List<Pos> directList= new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        directList.add(new Pos(1, 0));
        directList.add(new Pos(-1, 0));
        directList.add(new Pos(0, 1));
        directList.add(new Pos(0, -1));

        while(scanner.hasNextInt()){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[][] map = new int[x][y];
            for (int i = 0; i < x; ++i){
                for (int j = 0; j < y; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            Stack<Pos> path = new Stack<Pos>();
            path.push(new Pos(0, 0));
            List<Pos> list = findOut(map, new Pos(0, 0), D, path);
            if (list != null){
                for (Pos pos : list) {
                    System.out.println(String.format("(%d,%d)", pos.x, pos.y));
                }
            }

        }

    }

    /**
     *
     * @param map: 地图
     * @param currentPos: 当前位置
     * @param direction: 上一步的方向
     * @param path: 路径
     * @return 路径
     */
    private static Stack<Pos> findOut(int[][] map, Pos currentPos, int direction, Stack<Pos> path) {
        if (currentPos.x  == map.length - 1 && currentPos.y == map[currentPos.x].length - 1){
            return path;
        }
        Pos forbiddenPos;
        if (direction == U){
            forbiddenPos = new Pos(1, 0);
        } else if (direction == D){
            forbiddenPos = new Pos(-1, 0);
        } else if (direction == L){
            forbiddenPos = new Pos(0, 1);
        } else {
            forbiddenPos = new Pos(0, -1);
        }
        Stack<Pos> minDistancePath = null;
        for (int i = 0; i < directList.size(); ++i){
            int directionX = directList.get(i).x;
            int directionY = directList.get(i).y;
            if (directionX == forbiddenPos.x && directionY == forbiddenPos.y){
                continue;
            } else {
                int nextPosX = currentPos.x + directionX;
                int nextPosY = currentPos.y + directionY;
                if (0 <= nextPosX && nextPosX < map.length && 0 <= nextPosY && nextPosY < map[nextPosX].length && map[nextPosX][nextPosY] == 0){
                    int d;
                    if (nextPosX - currentPos.x != 0){
                        if (nextPosX - currentPos.x == 1){
                            d = D;
                        } else {
                            d = U;
                        }
                    } else {
                        if (nextPosY - currentPos.y == 1){
                            d = R;
                        } else {
                            d = L;
                        }
                    }
                    Pos nextPos = new Pos(nextPosX, nextPosY);
                    path.push(nextPos);
                    Stack<Pos> res = findOut(map, nextPos, d, path);
                    if (res != null && minDistancePath == null){
                        minDistancePath = (Stack<Pos>) res.clone();
                    } else if (res != null && res.size() < minDistancePath.size()){
                        minDistancePath = (Stack<Pos>) res.clone();
                    }
                    path.pop();
                }
            }
        }
        return minDistancePath;
    }

    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
