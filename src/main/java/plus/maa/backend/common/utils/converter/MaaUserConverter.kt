package plus.maa.backend.common.utils.converter

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import plus.maa.backend.controller.response.user.MaaUserInfo
import plus.maa.backend.repository.entity.MaaUser
import java.util.*

/**
 * @author dragove
 * created on 2022/12/26
 */
@Mapper(
    componentModel = "spring", imports = [Objects::class
    ]
)
interface MaaUserConverter {
    @Mapping(source = "userId", target = "id")
    @Mapping(target = "activated", expression = "java(Objects.equals(user.getStatus(), 1))")
    @Mapping(target = "uploadCount", ignore = true)
    fun convert(user: MaaUser): MaaUserInfo
}
