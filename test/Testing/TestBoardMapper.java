/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

/**
 *
 * @author fadia
 */
import online_monopoly.BoardMapper;
import online_monopoly.Point;
import org.junit.*;
import org.junit.Assert.*;
import java.util.*;
public class TestBoardMapper {
    private BoardMapper boardMapper = new BoardMapper(700);
    @Test
    public void test(){
        ArrayList<Point> corner = boardMapper.getCorners(0, 39, true);
    }
}
