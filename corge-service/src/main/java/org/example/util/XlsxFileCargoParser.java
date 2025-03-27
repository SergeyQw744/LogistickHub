package org.example.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.example.entity.Cargo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class XlsxFileCargoParser {

    private final Map<Integer, String> strategySetFields = Map.of(
            0, "CargoName",
            1, "RegistrationNumber",
            3, "UnitOfWeight",
            4, "PathIdentifier"
    );

    public List<Cargo> toListCargo(InputStream inputStream) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Cargo> cargos = new ArrayList<>();
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        if (it.hasNext()) {
            it.next();
        }
        while(it.hasNext()){
            Row row = it.next();
            Cargo cargo = new Cargo();
            Iterator<Cell> cells = row.iterator();
            int cellIndex = 0;
            while(cells.hasNext()){
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch(cellType){
                    case Cell.CELL_TYPE_STRING:
                        String setterName = "set" + strategySetFields.get(cellIndex);
                        Method setNameMethod = Cargo.class.getDeclaredMethod(setterName, String.class);
                        setNameMethod.invoke(cargo, cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (cellIndex == 2){
                            cargo.setWeight(cell.getNumericCellValue());
                        }
                        break;
                    default:
                        break;
                }
                cellIndex++;
            }
            cargos.add(cargo);
        }
        workbook.close();
        return cargos;
    }
}
