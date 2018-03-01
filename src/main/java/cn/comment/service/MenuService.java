package cn.comment.service;

import java.util.List;

import cn.comment.dto.MenuDto;
import cn.comment.dto.MenuForMoveDto;
import cn.comment.dto.MenuForZtreeDto;



public interface MenuService {
	
	/**
	 * 获取菜单树列表
	 * @return 菜单树列表
	 */
	List<MenuForZtreeDto> getZtreeList();
	
	/**
	 * 根据条件获取菜单列表
	 * @param menuDto 过滤条件
	 * @return
	 */
	List<MenuDto> getList(MenuDto menuDto);
	
	/**
	 * 新增菜单
	 * @param menuDto
	 * @return true:新增成功;false:新增失败
	 */
	boolean add(MenuDto menuDto);
	
	/**
	 * 删除菜单
	 * @param id
	 * @return true:删除成功;false:删除失败
	 */
	boolean remove(Long id);
	
	/**
	 * 通过id获取菜单
	 * @param id
	 * @return 菜单dto对象
	 */
	MenuDto getById(Long id);
	
	/**
	 * 修改菜单
	 * @param menuDto
	 * @return true:修改成功;false:修改失败
	 */
	boolean modify(MenuDto menuDto);
	
	/**
	 * 菜单排序
	 * @param menuDto
	 * @return true:排序成功;false:排序失败
	 */
	boolean order(MenuForMoveDto menuForMoveDto);
}
