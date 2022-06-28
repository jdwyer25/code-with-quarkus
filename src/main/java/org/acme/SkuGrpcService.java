package org.acme;

import Repositories.SkuRepository;
import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

@GrpcService
public class SkuGrpcService implements SkuGrpc {
    SkuRepository skuRepository;

    public SkuGrpcService(){
        skuRepository = new SkuRepository();
    }

    /**
     * Gets a page of skus
     * @param request The sku request
     * @return the page of skus
     */
    @Override
    public Uni<SkuResult> getSkus(PagingRequest request) {
        var skuPage = skuRepository.GetSkus(request.getPageSize(), request.getPageNumber());

        var skuResultBuilder = SkuResult.newBuilder()
                .setPaging(PagingResult.newBuilder()
                        .setPageNumber(skuPage.Pagination.PageNumber)
                        .setPageSize(skuPage.Pagination.PageSize)
                        .setTotalItemCount(skuPage.Pagination.TotalItems));

        for(int i=0;i<skuPage.DomainModels.size(); i++){
            var skuDomainModel = skuPage.DomainModels.get(i);
            var sku = Sku.newBuilder()
                    .setSkuId(skuDomainModel.getSkuId())
                    .setCategory(skuDomainModel.getCategory())
                    .setName(skuDomainModel.getName())
                    .build();

            skuResultBuilder.addSkus(sku);
        }


        return Uni.createFrom().item("getSkus")
                .map(res -> skuResultBuilder.build());
    }
}
