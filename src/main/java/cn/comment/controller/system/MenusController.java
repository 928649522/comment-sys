package cn.comment.controller.system;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.comment.constant.PageCodeEnum;
import cn.comment.dto.MenuDto;
import cn.comment.dto.MenuForMoveDto;
import cn.comment.dto.MenuForZtreeDto;
import cn.comment.dto.PageCodeDto;
import cn.comment.service.MenuService;

/**
 * 菜单相关
 */
@RestController
@RequestMapping("/menus")
public class MenusController {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 获取菜单列表
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<MenuForZtreeDto> getList() {
		return menuService.getZtreeList();
	}
	
	/**
	 * 新增菜单
	 */
	@RequestMapping(method = RequestMethod.POST)
	public PageCodeDto add(MenuDto menuDto) {
		PageCodeDto result;
		if(menuService.add(menuDto)) {
			result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.ADD_FAIL);
		}
		return result;
	}
	
	/**
	 * 菜单排序
	 */
	@RequestMapping(value="/{dropNodeId}/{targetNodeId}/{moveType}",method = RequestMethod.PUT)
	public PageCodeDto order(MenuForMoveDto menuForMoveDto) {
		PageCodeDto result;
		if(menuService.order(menuForMoveDto)) {
			result = new PageCodeDto(PageCodeEnum.ORDER_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.ORDER_FAIL);
		}
		return result;
	}
	
	/**
	 * 根据主键获取菜单dto
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public MenuDto getById(@PathVariable("id") Long id) {
		return menuService.getById(id);
	}
	
	/**
	 * 修改菜单
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public PageCodeDto modify(MenuDto menuDto) {
		PageCodeDto result;
		if(menuService.modify(menuDto)) {
			result = new PageCodeDto(PageCodeEnum.UPDATE_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.UPDATE_FAIL);
		}
		return result;
	}
	
	/**
	 * 删除菜单
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public PageCodeDto remove(@PathVariable("id")Long id) {
		PageCodeDto result;
		MenuDto menuDto = new MenuDto();
		menuDto.setParentId(id);
		List<MenuDto> list = menuService.getList(menuDto);
		if(list.size() > 0) {
			result = new PageCodeDto(PageCodeEnum.SUB_MENU_EXISTS);
		} else {
			if(menuService.remove(id)) {
				result = new PageCodeDto(PageCodeEnum.DELETE_SUCCESS);
			} else {
				result = new PageCodeDto(PageCodeEnum.DELETE_FAIL);
			}
		}
		return result;
	}
}