package team2.spring.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Reader;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderStatisticDto {
  @NotBlank
  private String name;
  @NotBlank
  private String select;
  private Map<Reader, List<Book>> readerListMap;
  private Map<Reader, LocalDate> readerDateMap;
}
