package com.wen.cloud.handller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wen.cloud.model.CommonResult;

public class CustomBlockHandler {
    public CommonResult handleException(BlockException excep){
        return new CommonResult("自定义限流",200);
    }
}
