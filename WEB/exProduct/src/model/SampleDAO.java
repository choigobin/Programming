package model;

import java.util.List;

public interface SampleDAO {
	int insert(SampleDTO dto);
	SampleDTO readOne(SampleDTO dto);
	List<SampleDTO> readList();
	int update(SampleDTO dto);
	int delete(SampleDTO dto);
}
