package jp.co.kksoft.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.kksoft.web.entity.BokuEntity;
import jp.co.kksoft.web.model.RegisterModel;

@Mapper
public interface RigsterMapper {

	int creatUser(RegisterModel registerModel);

	int checkLogin(RegisterModel registerModel);

	List<BokuEntity> getAllUserList();
}
