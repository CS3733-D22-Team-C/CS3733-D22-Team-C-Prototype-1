package edu.wpi.cs3733.D22.teamC.controller.location.map.map_view;

import edu.wpi.cs3733.D22.teamC.entity.location.Location;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class EditMapController extends MapController {
    //#region Mouse Events
        @Override
        protected void onMouseClickedNode(MouseEvent event, LocationNode locationNode) {
            super.onMouseClickedNode(event, locationNode);

            if (event.getButton().equals(MouseButton.SECONDARY)) {
                // Single-Click delete LocationNode
                parentController.deleteLocation(locationNode.location);
            }
        }

        @Override
        protected void onMouseClickedMap(MouseEvent event) {
            super.onMouseClickedMap(event);

            if (event.getButton().equals(MouseButton.PRIMARY)) {
                // Double-Click create new LocationNode
                if (event.getClickCount() == 2) {
                    Location location = createLocation((int) event.getX(), (int) event.getY());
                    parentController.addLocation(location);
                    parentController.changeCurrentLocation(location);
                }
            }
        }

        @Override
        protected void onMouseDraggedNode(MouseEvent event, LocationNode locationNode) {
            super.onMouseDraggedNode(event, locationNode);

            if (event.getButton().equals(MouseButton.PRIMARY))  {
                double offsetX = event.getX() - locationNode.getLocationNodeGroup().getTranslateX();
                double offsetY = event.getY() - locationNode.getLocationNodeGroup().getTranslateY();

                int newMapX = (int) (locationNode.getLocationNodeGroup().getTranslateX() + offsetX);
                newMapX = Math.max(0, newMapX);
                newMapX = Math.min((int) mapPane.getPrefWidth(), newMapX);
                int newMapY = (int) (locationNode.getLocationNodeGroup().getTranslateY() + offsetY);
                newMapY = Math.max(0, newMapY);
                newMapY = Math.min((int) mapPane.getPrefHeight(), newMapY);

                locationNode.setPosition(newMapX, newMapY);

                locationNode.location.setX(newMapX);
                locationNode.location.setY(newMapY);
            }
        }

        public Location createLocation(int x, int y) {
            // Create Location
            Location location = new Location();

            location.setX((int) x);
            location.setY((int) y);
            location.setFloor(parentController.getCurrentFloor().getFloorID());
            location.setNodeType(Location.NodeType.PATI);

            return location;
        }
    //#endregion
}
